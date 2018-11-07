package com.lixiaozhuo.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.lixiaozhuo.utils.UserContext;

public class LoginInterceptor implements HandlerInterceptor {
	//控制器方法执行之前执行,返回结果为true表示放行,如果返回为false,表示拦截
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		System.out.println("LoginInterceptor.preHandle()");
		Object object = request.getSession().getAttribute(UserContext.USERINSESSION);
		if (object != null) {
			return true;
		}
		response.sendRedirect("/login.jsp");		
		return false;                                                                                          
	}
	
	//控制前方法执行后,视图渲染之前执行.
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}
	
	//视图渲染之后执行
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}
}
