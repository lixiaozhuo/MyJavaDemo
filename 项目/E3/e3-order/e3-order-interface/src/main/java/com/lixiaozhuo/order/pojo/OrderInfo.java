package com.lixiaozhuo.order.pojo;

import java.util.List;

import com.lixiaozhuo.pojo.TbOrder;
import com.lixiaozhuo.pojo.TbOrderItem;
import com.lixiaozhuo.pojo.TbOrderShipping;

/**
 * 订单信息
 * 
 * @author lxz
 *
 */
public class OrderInfo extends TbOrder {

	private static final long serialVersionUID = 1L;
	/**
	 * 订单明细
	 */
	private List<TbOrderItem> orderItems;
	/**
	 * 订单物流
	 */
	private TbOrderShipping orderShipping;

	public List<TbOrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<TbOrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public TbOrderShipping getOrderShipping() {
		return orderShipping;
	}

	public void setOrderShipping(TbOrderShipping orderShipping) {
		this.orderShipping = orderShipping;
	}

}
