package com.lixiaozhuo.cart.Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.lixiaozhuo.pojo.E3Result;
import com.lixiaozhuo.pojo.TbUser;
import com.lixiaozhuo.sso.service.TokenService;
import com.lixiaozhuo.utils.CookieUtils;

/**
 * 登录拦截过滤器
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
	 * 执行handler之前
	 */
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		// 从cookie中取token
		String token = CookieUtils.getCookieValue(request, "token");
		// 如果没有token,未登录状态,放行
		if(StringUtils.isBlank(token)){
			return true;
		}
		// 取token ,根据token取用户信息
		E3Result e3Result = tokenService.getUserByToken(token);
		// 没有取到用户信息,登录过期,放行
		if(e3Result.getStatus()!=200){
			return true;
		}
		// 取到用户信息
		TbUser user = (TbUser) e3Result.getData();
		// 把用户信息放到request中
		request.setAttribute("user", user);
		return true;
	}

	/**
	 * 执行handler后,返回ModeAndView之前
	 */
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	/**
	 * 返回ModeAndView之后(处理异常)
	 */
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}

}
