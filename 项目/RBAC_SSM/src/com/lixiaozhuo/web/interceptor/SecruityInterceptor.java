package com.lixiaozhuo.web.interceptor;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.lixiaozhuo.domain.Employee;
import com.lixiaozhuo.utils.PermissionUtil;
import com.lixiaozhuo.utils.RequiredPermission;
import com.lixiaozhuo.utils.UserContext;

public class SecruityInterceptor implements HandlerInterceptor {
	// 控制器方法执行之前执行,返回结果为true表示放行,如果返回为false,表示拦截
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		System.out.println("SecruityInterceptor.preHandle()");
		Employee currentUser = (Employee) request.getSession()
				.getAttribute(UserContext.USERINSESSION);
		// 登录用户为超级管理员,放行
		System.out.println(currentUser);
		if (currentUser.getAdmin()) {
			return true;
		}
		if (!(handler instanceof HandlerMethod)) {
			return true;
		}
		HandlerMethod method = (HandlerMethod) handler;
		// 方法上没有RequiredPermission注解,放行
		if (!method.hasMethodAnnotation(RequiredPermission.class)) {
			return true;
		}
		// 获取方法对应的权限
		String permissionExpression = PermissionUtil
				.buildPermissionExpression(method.getMethod());
		System.out.println(permissionExpression);
		// 获取session中的用户权限
		@SuppressWarnings("unchecked")
		Set<String> permissions = (Set<String>) request.getSession()
				.getAttribute(UserContext.PERMISSIONINSESSION);
		if (permissions.contains(permissionExpression)) {
			return true;
		}
		request.getRequestDispatcher("/WEB-INF/view/common/nopermission.jsp")
				.forward(request, response);
		return false;
	}

	// 控制前方法执行后,视图渲染之前执行.
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	// 视图渲染之后执行
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}
}
