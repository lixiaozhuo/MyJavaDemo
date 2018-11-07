package com.lixiaozhuo.content.service;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lixiaozhuo.jedis.JedisClient;
import com.lixiaozhuo.mapper.TbContentMapper;
import com.lixiaozhuo.pojo.E3Result;
import com.lixiaozhuo.pojo.EasyUIDataGridResult;
import com.lixiaozhuo.pojo.TbContent;
import com.lixiaozhuo.pojo.TbContentExample;
import com.lixiaozhuo.pojo.TbContentExample.Criteria;
import com.lixiaozhuo.utils.JsonUtils;

/**
 * 网站内容服务
 * 
 * @author lxz
 *
 */
@Service
public class ContentServiceImpl implements ContentService {
	/**
	 * 内容Mapper
	 */
	@Autowired
	private TbContentMapper contentMapper;

	/**
	 * Jedis自定义客户端
	 */
	@Autowired
	private JedisClient jedisClient;

	/**
	 * Redis缓存中内容列表key
	 */
	@Value("${CONTENT_LIST}")
	private String CONTENT_LIST;

	@Override
	public List<TbContent> getContentByCid(long cid) {
		// 查询缓存
		try {
			// 查询huancun
			String json = jedisClient.hget(CONTENT_LIST, cid + "");
			// 缓存中存在数据直接响应结果
			if (StringUtils.isNotBlank(json)) {
				List<TbContent> list = JsonUtils.jsonToList(json,
						TbContent.class);
				return list;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 查询数据库,根据分类id查询内容列表
		// 设置查询条件
		TbContentExample example = new TbContentExample();
		Criteria criteria = example.createCriteria();
		criteria.andCategoryIdEqualTo(cid);
		// 执行查询
		List<TbContent> list = contentMapper.selectByExampleWithBLOBs(example);

		try {
			// 把结果添加到缓存
			jedisClient.hset(CONTENT_LIST, cid + "",
					JsonUtils.objectToJson(list));
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 返回结果
		return list;
	}

	@Override
	public String getAttributeContent(long id) {
		// 执行查询
		TbContent content = contentMapper.selectByPrimaryKey(id);
		//返回content属性
		return content.getContent();
	}

	@Override
	public EasyUIDataGridResult getContentListByCid(long categoryId,
			Integer pageNum, Integer pageSize) {
		// 设置分页信息
		PageHelper.startPage(pageNum, pageSize);
		// 根据分类id查询内容列表
		// 设置查询条件
		TbContentExample example = new TbContentExample();
		Criteria criteria = example.createCriteria();
		criteria.andCategoryIdEqualTo(categoryId);
		// 执行查询
		List<TbContent> list = contentMapper.selectByExampleWithBLOBs(example);

		// 返回值对象
		EasyUIDataGridResult result = new EasyUIDataGridResult();
		result.setRows(list);
		// 获取分页信息
		PageInfo<TbContent> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		// 返回结果
		return result;
	}

	@Override
	public E3Result addContent(TbContent tbContent) {
		// 补全商品内容信息
		tbContent.setUpdated(new Date());
		tbContent.setCreated(new Date());
		// 插入数据到数据库中
		contentMapper.insert(tbContent);

		try {
			// 同步缓存
			jedisClient.hdel(CONTENT_LIST,
					tbContent.getCategoryId().toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 响应结果
		return E3Result.ok();
	}

	@Override
	public E3Result updateContent(TbContent tbContent) {
		// 更新Updated属性
		tbContent.setUpdated(new Date());
		// 更新数据到数据库中
		contentMapper.updateByPrimaryKeySelective(tbContent);
		try {
			// 同步缓存
			jedisClient.hdel(CONTENT_LIST,
					tbContent.getCategoryId().toString());
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 响应结果
		return E3Result.ok();
	}

	@Override
	public E3Result deleteContent(String contentIds) {

		if (!StringUtils.isBlank(contentIds)) {
			// 分割id
			String[] ids = contentIds.split(",");
			// 批量删除
			for (String id : ids) {
				// 获取商品信息
				TbContent tbContent = contentMapper
						.selectByPrimaryKey(Long.valueOf(id));
				// 执行删除
				contentMapper.deleteByPrimaryKey(Long.valueOf(id));

				try {
					// 同步缓存
					jedisClient.hdel(CONTENT_LIST,
							tbContent.getCategoryId().toString());

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			// 响应结果
			return E3Result.ok();
		}
		return E3Result.build(500, "没有选择id");
	}

}
