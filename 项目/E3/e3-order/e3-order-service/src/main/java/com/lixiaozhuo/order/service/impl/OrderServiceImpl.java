package com.lixiaozhuo.order.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.lixiaozhuo.jedis.JedisClient;
import com.lixiaozhuo.mapper.TbOrderItemMapper;
import com.lixiaozhuo.mapper.TbOrderMapper;
import com.lixiaozhuo.mapper.TbOrderShippingMapper;
import com.lixiaozhuo.order.pojo.OrderInfo;
import com.lixiaozhuo.order.service.OrderService;
import com.lixiaozhuo.pojo.E3Result;
import com.lixiaozhuo.pojo.TbOrderItem;
import com.lixiaozhuo.pojo.TbOrderShipping;

/**
 * 订单业务
 * 
 * @author lxz
 *
 */
@Service
public class OrderServiceImpl implements OrderService {
	/**
	 * 订单Mapper
	 */
	@Autowired
	private TbOrderMapper orderMapper;

	/**
	 * 订单明细表Mapper
	 */
	@Autowired
	private TbOrderItemMapper orderItemMapper;

	/**
	 * 订单物流表Mapper
	 */
	@Autowired
	private TbOrderShippingMapper orderShippingMapper;
	/**
	 * jedis客户端
	 */
	@Autowired
	private JedisClient jedisClient;

	/**
	 * redis订单号key
	 */
	@Value("${ORDER_ID_GEN_KEN}")
	private String ORDER_ID_GEN_KEN;

	/**
	 * 订单号初始值
	 */
	@Value("${ORDER_ID_START}")
	private String ORDER_ID_START;

	/**
	 * redis订单明细key
	 */
	@Value("${ORDER_ITEM_ID_GEN_KEY}")
	private String ORDER_ITEM_ID_GEN_KEY;

	@Override
	public E3Result createOrder(OrderInfo orderInfo) {

		// 不存在订单号,初始订单号
		if (!jedisClient.exists(ORDER_ID_GEN_KEN)) {
			jedisClient.set(ORDER_ID_GEN_KEN, ORDER_ID_START);
		}
		// 生成订单号,使用redis的incr生成
		String orderId = jedisClient.incr(ORDER_ID_GEN_KEN).toString();
		// 补全属性
		orderInfo.setOrderId(orderId);
		// 状态：1、未付款，2、已付款，3、未发货，4、已发货，5、交易成功，6、交易关闭
		orderInfo.setStatus(1);
		orderInfo.setCreateTime(new Date());
		orderInfo.setUpdateTime(new Date());
		// 订单表插入数据
		orderMapper.insert(orderInfo);
		// 向订单明细表插入数据
		List<TbOrderItem> orderItems = orderInfo.getOrderItems();
		for (TbOrderItem tbOrderItem : orderItems) {
			//生成明细id
			String orderItemId = jedisClient.incr(ORDER_ITEM_ID_GEN_KEY).toString();
			//补全信息
			tbOrderItem.setId(orderItemId);
			tbOrderItem.setOrderId(orderId);
			//向明细表插入数据
			orderItemMapper.insert(tbOrderItem);
		}
		// 订单物流表插入数据
		TbOrderShipping orderShipping = orderInfo.getOrderShipping();
		//补全信息
		orderShipping.setOrderId(orderId);
		orderShipping.setCreated(new Date());
		orderShipping.setUpdated(new Date());
		//订单物流表插入数据
		orderShippingMapper.insert(orderShipping);
		
		// 返回响应结果,包含订单号
		return E3Result.ok(orderId);
	}

}
