package com.lixiaozhuo.order.service;

import com.lixiaozhuo.order.pojo.OrderInfo;
import com.lixiaozhuo.pojo.E3Result;
/**
 * 订单业务接口
 * @author lxz
 *
 */
public interface OrderService {
	/**
	 * 创建订单
	 * @param orderInfo 订单信息
	 * @return
	 */
	E3Result createOrder(OrderInfo orderInfo);
}
