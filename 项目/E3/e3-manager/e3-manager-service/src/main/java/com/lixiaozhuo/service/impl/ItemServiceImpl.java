package com.lixiaozhuo.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lixiaozhuo.jedis.JedisClient;
import com.lixiaozhuo.mapper.TbItemDescMapper;
import com.lixiaozhuo.mapper.TbItemMapper;
import com.lixiaozhuo.pojo.E3Result;
import com.lixiaozhuo.pojo.EasyUIDataGridResult;
import com.lixiaozhuo.pojo.TbItem;
import com.lixiaozhuo.pojo.TbItemDesc;
import com.lixiaozhuo.pojo.TbItemExample;
import com.lixiaozhuo.service.ItemService;
import com.lixiaozhuo.utils.IDUtils;
import com.lixiaozhuo.utils.JsonUtils;

/**
 * 商品服务
 * 
 * @author lxz
 *
 */
@Service
public class ItemServiceImpl implements ItemService {
	/**
	 * 商品Mapper
	 */
	@Autowired
	private TbItemMapper itemMapper;

	/**
	 * 商品详情Mapper
	 */
	@Autowired
	private TbItemDescMapper itemDescMapper;

	/**
	 * Jedis自定义客户端
	 */
	@Autowired
	private JedisClient jedisClient;

	/**
	 * jms模板
	 */
	@Autowired
	private JmsTemplate jmsTemplate;

	/**
	 * Destination
	 */
	@Resource
	private Destination topicDestination;

	/**
	 * redis缓存中商品数据key的前缀
	 */
	@Value("${REDIS_ITEM_PRE}")
	private String REDIS_ITEM_PRE;

	/**
	 * 商品数据缓存过期时间,
	 */
	@Value("${ITEM_CACHE_EXPIRE}")
	private Integer ITEM_CACHE_EXPIRE;

	@Override
	public TbItem getItemById(long itemId) {
		// 查询缓存
		try {
			// 获取缓存中商品数据
			String json = jedisClient
					.get(REDIS_ITEM_PRE + ":" + itemId + ":BASE");
			// 缓存中存在直接响应结果
			if (StringUtils.isNotBlank(json)) {
				TbItem tbItem = JsonUtils.jsonToPojo(json, TbItem.class);
				return tbItem;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 执行查询
		TbItem tbItem = itemMapper.selectByPrimaryKey(itemId);
		try {
			// 把结果添加到缓存
			jedisClient.set(REDIS_ITEM_PRE + ":" + itemId + ":BASE",
					JsonUtils.objectToJson(tbItem));
			// 设置缓存过期时间
			jedisClient.expire(REDIS_ITEM_PRE + ":" + itemId + ":BASE",
					ITEM_CACHE_EXPIRE);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tbItem;
	}

	@Override
	public TbItemDesc getItemDescById(long itemId) {
		// 查询缓存
		try {
			// 获取缓存中商品详情数据
			String json = jedisClient
					.get(REDIS_ITEM_PRE + ":" + itemId + ":DESC");
			// 缓存中存在直接响应结果
			if (StringUtils.isNotBlank(json)) {
				TbItemDesc tbItemDesc = JsonUtils.jsonToPojo(json,
						TbItemDesc.class);
				return tbItemDesc;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 执行查询
		TbItemDesc itemDesc = itemDescMapper.selectByPrimaryKey(itemId);
		try {
			// 把结果添加到缓存
			jedisClient.set(REDIS_ITEM_PRE + ":" + itemId + ":DESC",
					JsonUtils.objectToJson(itemDesc));
			// 设置缓存过期时间
			jedisClient.expire(REDIS_ITEM_PRE + ":" + itemId + ":DESC",
					ITEM_CACHE_EXPIRE);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 返回查询结果
		return itemDesc;
	}

	@Override
	public EasyUIDataGridResult getItemList(Integer pageNum, Integer pageSize) {
		// 设置分页信息
		PageHelper.startPage(pageNum, pageSize);
		// 执行查询
		TbItemExample example = new TbItemExample();
		List<TbItem> list = itemMapper.selectByExample(example);
		// 返回值对象
		EasyUIDataGridResult result = new EasyUIDataGridResult();
		result.setRows(list);
		// 获取分页信息
		PageInfo<TbItem> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		// 返回查询结果
		return result;
	}

	@Override
	public E3Result addItem(TbItem item, String desc) {
		// 生成商品id
		final long itemId = IDUtils.genItemId();
		// 补全TbItem对象的属性
		item.setId(itemId);
		// 商品状态 1-正常 2-下架 3-删除
		item.setStatus((byte) 1);
		// 设置创建和更新时间
		item.setCreated(new Date());
		item.setUpdated(new Date());
		// 向商品表插入数据
		itemMapper.insert(item);

		// 创建一个TbItemDesc对象
		TbItemDesc itemDesc = new TbItemDesc();
		// 补全TbItemDesc的属性
		itemDesc.setItemId(itemId);
		itemDesc.setItemDesc(desc);
		itemDesc.setCreated(new Date());
		itemDesc.setUpdated(new Date());
		// 向商品描述表插入数据
		itemDescMapper.insert(itemDesc);

		// 发送商品添加消息
		jmsTemplate.send(topicDestination, new MessageCreator() {
			@Override
			public Message createMessage(Session session) throws JMSException {
				return session.createTextMessage(itemId + "");
			}
		});

		// 返回响应信息
		return E3Result.ok();
	}

	@Override
	public E3Result updateItem(TbItem item, String desc) {
		// 更新update属性
		item.setUpdated(new Date());
		// 更新商品表数据
		itemMapper.updateByPrimaryKeySelective(item);
		
		// 创建一个TbItemDesc对象
		TbItemDesc itemDesc = new TbItemDesc();
		// 补充TbItemDesc的属性
		itemDesc.setItemId(item.getId());
		itemDesc.setItemDesc(desc);
		//更新更新时间
		itemDesc.setUpdated(new Date());
		// 向商品描述表插入数据
		itemDescMapper.updateByPrimaryKeySelective(itemDesc);

		try {
			// 同步缓存
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 返回响应信息
		return E3Result.ok();
	}

	@Override
	public E3Result deleteItem(String itemIds) {
		if (!StringUtils.isBlank(itemIds)) {
			// 分割id
			String[] ids = itemIds.split(",");
			// 批量删除
			for (String id : ids) {
				//删除商品信息
				itemMapper.deleteByPrimaryKey(Long.valueOf(id));
				//删除商品描述信息
				itemDescMapper.deleteByPrimaryKey(Long.valueOf(id));
			}
			// 返回响应信息
			return E3Result.ok();
		}
		return E3Result.build(500, "删除错误,请选中商品");
	}

	@Override
	public E3Result instockItem(String itemIds) {
		if (!StringUtils.isBlank(itemIds)) {
			// 分割id
			String[] ids = itemIds.split(",");
			// 批量下架
			for (String id : ids) {
				// 查询商品信息
				TbItem item = itemMapper.selectByPrimaryKey(Long.valueOf(id));
				// 更改商品状态 1-正常 2-下架 3-删除
				item.setStatus((byte) 2);
				// 更新商品表数据
				itemMapper.updateByPrimaryKeySelective(item);
			}
			// 返回响应信息
			return E3Result.ok();
		}
		return E3Result.build(500, "下架错误,请选中商品");
	}

	@Override
	public E3Result reshelfItem(String itemIds) {
		if (!StringUtils.isBlank(itemIds)) {
			// 分割id
			String[] ids = itemIds.split(",");
			// 批量上架
			for (String id : ids) {
				// 查询商品信息
				TbItem item = itemMapper.selectByPrimaryKey(Long.valueOf(id));
				// 更改商品状态 1-正常 2-下架 3-删除
				item.setStatus((byte) 1);
				// 更新商品表数据
				itemMapper.updateByPrimaryKeySelective(item);
			}
			// 返回响应信息
			return E3Result.ok();
		}
		return E3Result.build(500, "上架错误,请选中商品");
	}

}
