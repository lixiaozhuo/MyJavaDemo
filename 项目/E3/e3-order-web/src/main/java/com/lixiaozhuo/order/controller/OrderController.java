package com.lixiaozhuo.order.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lixiaozhuo.cart.service.CartService;
import com.lixiaozhuo.order.pojo.OrderInfo;
import com.lixiaozhuo.order.service.OrderService;
import com.lixiaozhuo.pojo.E3Result;
import com.lixiaozhuo.pojo.TbItem;
import com.lixiaozhuo.pojo.TbUser;

/**
 * 订单控制器
 * 
 * @author lxz
 *
 */
@Controller
public class OrderController {
	/**
	 * 购物车Service
	 */
	@Autowired
	private CartService cartService;

	/**
	 * 订单Service
	 */
	@Autowired
	private OrderService orderService;

	@RequestMapping("/order/order-cart")
	public String showOrderCart(HttpServletRequest request) {
		// 取用户id
		TbUser user = (TbUser) request.getAttribute("user");
		// 获取支付方式列表
		// 根据用户id取收货地址列表
		// 根据用户id获取购物车列表
		List<TbItem> cartList = cartService.getCartItem(user.getId());
		// 把购物车列表传递给页面
		request.setAttribute("cartList", cartList);
		// 返回页面
		return "order-cart";
	}

	@RequestMapping(value = "/order/create", method = RequestMethod.POST)
	public String createOrder(OrderInfo orderInfo, HttpServletRequest request) {
		// 取用户信息
		TbUser user = (TbUser) request.getAttribute("user");
		// 把用户信息添加到order
		orderInfo.setUserId(user.getId());
		orderInfo.setBuyerNick(user.getUsername());
		// 调用服务生成订单
		E3Result result = orderService.createOrder(orderInfo);
		// 如果订单生成成功,需要删除购物车
		if (result.getStatus() == 200) {
			// 清空购物车
			cartService.clearCartItem(user.getId());
		}
		// 把数据传递给页面
		request.setAttribute("orderId", result.getData());
		request.setAttribute("payment", orderInfo.getPayment());

		// 返回逻辑视图
		return "success";
	}

}
