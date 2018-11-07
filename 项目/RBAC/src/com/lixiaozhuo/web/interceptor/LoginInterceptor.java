package com.lixiaozhuo.web.interceptor;

import com.lixiaozhuo.utils.UserContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

//登录拦截器
public class LoginInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		//获取登录用户
		Object currentUser = invocation.getInvocationContext().getSession()
				.get(UserContext.USERINSESSION);
		System.out.println(currentUser);
		//没有登录,跳转到登录页面
		if (currentUser == null) {
			return "login";
		}
		System.out.println(currentUser);
		//放行资源
		return invocation.invoke();
	}

}
