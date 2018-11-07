package com.lixiaozhuo.cart.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lixiaozhuo.cart.service.CartService;
import com.lixiaozhuo.pojo.E3Result;
import com.lixiaozhuo.pojo.TbItem;
import com.lixiaozhuo.pojo.TbUser;
import com.lixiaozhuo.service.ItemService;
import com.lixiaozhuo.utils.CookieUtils;
import com.lixiaozhuo.utils.JsonUtils;

/**
 * 购物车
 * 
 * @author lxz
 *
 */
@Controller
public class CartController {
	/**
	 * 商品服务
	 */
	@Autowired
	private ItemService itemService;

	/**
	 * 购物车服务
	 */
	@Autowired
	private CartService cartService;

	/**
	 *  cookie中的购物车保存时间
	 */
	@Value("${COOKIE_CART_EXPIRE}")
	private Integer COOKIE_CART_EXPIRE;

	/**
	 * 从cookie中取购物车列表
	 * 
	 * @return
	 */
	private List<TbItem> getCartListFromCookie(HttpServletRequest request) {
		String json = CookieUtils.getCookieValue(request, "cart", true);
		// 判断json是否为空
		if (StringUtils.isBlank(json)) {
			return new ArrayList<>();
		}
		// 把json转换成商品列表
		List<TbItem> list = JsonUtils.jsonToList(json, TbItem.class);
		return list;
	}

	/**
	 * 显示购物车列表
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/cart/cart")
	public String showCartList(HttpServletRequest request,
			HttpServletResponse response) {
		// 从cookie中取购物车列表
		List<TbItem> cartList = getCartListFromCookie(request);
		// 判断用户是否为登录状态
		TbUser user = (TbUser) request.getAttribute("user");
		// 如果是登录状态
		if (user != null) {
			// 如果不为空,把cookie中的购物车商品和服务端的购物车商品合并
			cartService.mergeCartItem(user.getId(), cartList);
			// 把cookie中的购物车删除
			CookieUtils.deleteCookie(request, response, "cart");
			// 从服务端取购物车列表
			cartList = cartService.getCartItem(user.getId());
		}
		// 把列表传递给页面
		request.setAttribute("cartList", cartList);
		// 返回逻辑视图
		return "cart";
	}

	/**
	 * 购物车添加商品
	 * 
	 * @param itemId
	 *            商品id
	 * @param num
	 *            商品数量
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/cart/add/{itemId}")
	private String addCartItem(@PathVariable Long itemId,
			@RequestParam(defaultValue = "1") Integer num,
			HttpServletRequest request, HttpServletResponse response) {
		// 判断用户是否登录
		TbUser user = (TbUser) request.getAttribute("user");
		// 如果是登录状态,把购物车写入redis
		if (user != null) {
			// 保存到服务端
			cartService.addCartItem(user.getId(), itemId, num);
			// 返回添加成功页面
			return "cartSuccess";
		}

		// 未登录,写入cookie
		// 从cookie中取购物车列表
		List<TbItem> cartList = getCartListFromCookie(request);
		// 判断商品在商品列表中是否存在
		boolean flag = false;
		for (TbItem tbItem : cartList) {
			if (tbItem.getId().equals(itemId)) {
				// 如果存在数量相加
				tbItem.setNum(tbItem.getNum() + num);
				// 跳出循环
				flag = true;
				break;
			}
		}
		// 如果不存在,根据商品id查询商品信息,得到TbItem对象
		if (!flag) {
			// 根据商品id查询商品信息,得到一个TbItem对象
			TbItem tbItem = itemService.getItemById(itemId);
			// 设置商品数量
			tbItem.setNum(num);
			// 取一张图片
			if (StringUtils.isNotBlank(tbItem.getImage())) {
				tbItem.setImage(tbItem.getImage().split(",")[0]);
			}
			// 把商品添加到商品列表
			cartList.add(tbItem);
		}
		// 写入cookie
		CookieUtils.setCookie(request, response, "cart",
				JsonUtils.objectToJson(cartList), COOKIE_CART_EXPIRE, true);
		// 返回添加成功页面
		return "cartSuccess";
	}

	/**
	 * 更新购物车商品数量
	 * 
	 * @param itemId
	 *            商品id
	 * @param num
	 *            商品数量
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/cart/update/num/{itemId}/{num}")
	@ResponseBody
	public E3Result updateCartNum(@PathVariable Long itemId,
			@PathVariable Integer num, HttpServletRequest request,
			HttpServletResponse response) {
		// 判断用户是否为登录状态
		TbUser user = (TbUser) request.getAttribute("user");
		// 如果是登录状态,把购物车写入redis
		if (user != null) {
			// 更新商品数量
			cartService.updateCartNum(user.getId(), itemId, num);
			// 返回响应
			return E3Result.ok();
		}
		// 用户未登录
		// 从cookie中取购物车列表
		List<TbItem> cartList = getCartListFromCookie(request);
		// 遍历商品列表找到对应的商品
		for (TbItem tbItem : cartList) {
			if (tbItem.getId().equals(itemId)) {
				// 更新数量
				tbItem.setNum(num);
				break;
			}
		}
		// 把购物车列表写回cookie
		CookieUtils.setCookie(request, response, "cart",
				JsonUtils.objectToJson(cartList), COOKIE_CART_EXPIRE, true);
		// 返回响应
		return E3Result.ok();
	}

	/**
	 * 删除购物车商品
	 * 
	 * @param itemId
	 * @return
	 */
	@RequestMapping("/cart/delete/{itemId}")
	public String deleteCartItem(@PathVariable Long itemId,
			HttpServletRequest request, HttpServletResponse response) {
		// 判断用户是否为登录状态
		TbUser user = (TbUser) request.getAttribute("user");
		// 如果是登录状态,把购物车写入redis
		if (user != null) {
			// 删除购物车
			cartService.deleteCartItem(user.getId(), itemId);
			// 返回逻辑视图
			return "redirect:/cart/cart.html";
		}
		//用户未登录
		// 从cookie中取购物车列表
		List<TbItem> cartList = getCartListFromCookie(request);
		// 遍历商品列表找到对应的商品
		for (TbItem tbItem : cartList) {
			if (tbItem.getId().equals(itemId)) {
				// 删除商品
				cartList.remove(tbItem);
				break;
			}
		}
		// 把购物车列表写回cookie
		CookieUtils.setCookie(request, response, "cart",
				JsonUtils.objectToJson(cartList), COOKIE_CART_EXPIRE, true);
		// 返回逻辑视图
		return "redirect:/cart/cart.html";
	}

}
