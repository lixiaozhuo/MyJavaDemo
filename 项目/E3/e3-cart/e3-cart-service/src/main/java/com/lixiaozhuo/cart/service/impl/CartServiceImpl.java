package com.lixiaozhuo.cart.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.lixiaozhuo.cart.service.CartService;
import com.lixiaozhuo.jedis.JedisClient;
import com.lixiaozhuo.mapper.TbItemMapper;
import com.lixiaozhuo.pojo.E3Result;
import com.lixiaozhuo.pojo.TbItem;
import com.lixiaozhuo.utils.JsonUtils;

/**
 * 购物车服务
 * 
 * @author lxz
 *
 */
@Service
public class CartServiceImpl implements CartService {
	/**
	 * jedis客户端
	 */
	@Autowired
	public JedisClient jedisClient;
	
	/**
	 * 商品mapper
	 */
	@Autowired
	private TbItemMapper itemMapper;

	/**
	 * redis购物车key前缀
	 */
	@Value("${REDIS_CART_PRE}")
	private String REDIS_CART_PRE;

	@Override
	public E3Result addCartItem(long userId, long itemId, int num) {
		// 向redis添加购物车,数据类型为hash(key:用户id,field:商品id,value:商品信息)

		// 判断redis中商品是否存在
		Boolean flag = jedisClient.hexists(REDIS_CART_PRE + ":" + userId,
				itemId + "");
		// 如果存在数量相加
		if (flag) {
			String json = jedisClient.hget(REDIS_CART_PRE + ":" + userId,
					itemId + "");
			// 把json转换成TbItem
			TbItem item = JsonUtils.jsonToPojo(json, TbItem.class);
			// 更新数量
			item.setNum(item.getNum() + num);
			// 写回redis
			jedisClient.hset(REDIS_CART_PRE + ":" + userId, itemId + "",
					JsonUtils.objectToJson(item));
			return E3Result.ok();

		}
		// 如果不存在,根据商品id取 商品信息
		TbItem item = itemMapper.selectByPrimaryKey(itemId);
		// 设置商品数量
		item.setNum(num);
		// 设置图片为一张
		if (StringUtils.isNotBlank(item.getImage())) {
			item.setImage(item.getImage().split(",")[0]);
		}

		// 添加到购物车列表
		jedisClient.hset(REDIS_CART_PRE + ":" + userId, itemId + "",
				JsonUtils.objectToJson(item));
		// 返回成功
		return E3Result.ok();
	}

	@Override
	public E3Result mergeCartItem(long userId, List<TbItem> itemList) {
		// 遍历商品列表
		for (TbItem tbItem : itemList) {
			// 将商品添加到购物车
			addCartItem(userId, tbItem.getId(), tbItem.getNum());
		}

		// 返回响应结果
		return E3Result.ok();
	}

	@Override
	public List<TbItem> getCartItem(long userId) {
		List<TbItem> result = new ArrayList<>();

		// 根据用户id获取购物车列表
		List<String> jsonList = jedisClient
				.hvals(REDIS_CART_PRE + ":" + userId);
		for (String string : jsonList) {
			TbItem item = JsonUtils.jsonToPojo(string, TbItem.class);
			// 商品信息加入结果集
			result.add(item);
		}
		return result;
	}

	@Override
	public E3Result updateCartNum(long userId, long itemId, int num) {
		// 获取商品信息
		String json = jedisClient.hget(REDIS_CART_PRE + ":" + userId,
				itemId + "");
		// 把json转换成TbItem
		TbItem item = JsonUtils.jsonToPojo(json, TbItem.class);
		// 更新数量
		item.setNum(num);
		// 写回redis
		jedisClient.hset(REDIS_CART_PRE + ":" + userId, itemId + "",
				JsonUtils.objectToJson(item));
		//返回响应结果
		return E3Result.ok();
	}

	@Override
	public E3Result deleteCartItem(long userId, long itemId) {
		// 删除缓存中的商品信息
		jedisClient.hdel(REDIS_CART_PRE + ":" + userId, itemId + "");

		// 返回结果
		return E3Result.ok();
	}

	@Override
	public E3Result clearCartItem(long userId) {
		//清空购物车
		jedisClient.del(REDIS_CART_PRE + ":" + userId);
		//返回结果
		return E3Result.ok();
	}

}
