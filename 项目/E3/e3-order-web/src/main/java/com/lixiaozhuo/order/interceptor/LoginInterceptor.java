package com.lixiaozhuo.order.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.lixiaozhuo.cart.service.CartService;
import com.lixiaozhuo.pojo.E3Result;
import com.lixiaozhuo.pojo.TbItem;
import com.lixiaozhuo.pojo.TbUser;
import com.lixiaozhuo.sso.service.TokenService;
import com.lixiaozhuo.utils.CookieUtils;
import com.lixiaozhuo.utils.JsonUtils;

/**
 * 登录拦截器
 * 
 * @author lxz
 *
 */
public class LoginInterceptor implements HandlerInterceptor {
	/**
	 * token服务
	 */
	@Autowired
	private TokenService tokenService;

	/**
	 * 购物车服务
	 */
	@Autowired
	private CartService cartService;

	/**
	 * sso登录系统url
	 */
	@Value("${SSO_URL}")
	private String SSO_URL;

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		// 从cookie中取token
		String token = CookieUtils.getCookieValue(request, "token");
		// 如果没有token,未登录状态,跳转到登录页面,登录成功后,跳转到当前url
		if (StringUtils.isBlank(token)) {
			response.sendRedirect(SSO_URL + "/page/login?redirect="
					+ request.getRequestURL());
			return false;
		}
		// 取token,根据token取用户信息
		E3Result e3Result = tokenService.getUserByToken(token);
		// 没有取到用户信息,登录过期,未登录状态,跳转到登录页面,登录成功后,跳转到当前url
		if (e3Result.getStatus() != 200) {
			response.sendRedirect(SSO_URL + "/page/login?redirect="
					+ request.getRequestURL());
			return false;
		}
		// 取到用户信息
		TbUser user = (TbUser) e3Result.getData();
		// 把用户信息放到request中
		request.setAttribute("user", user);
		// 判断cookie中是否有购物车数据,如果有合并到服务端
		String cart = CookieUtils.getCookieValue(request, "cart", true);
		if (StringUtils.isNotBlank(cart)) {
			// 合并购物车
			cartService.mergeCartItem(user.getId(),
					JsonUtils.jsonToList(cart, TbItem.class));
		}

		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}

}
