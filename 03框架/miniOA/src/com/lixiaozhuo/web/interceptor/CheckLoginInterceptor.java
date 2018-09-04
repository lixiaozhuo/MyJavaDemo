package com.lixiaozhuo.web.interceptor;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

//登录检查拦截器
public class CheckLoginInterceptor extends AbstractInterceptor{
	private static final long serialVersionUID = 1L;

	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("CheckLoginInterceptor.intercept()");
		Object object = ActionContext.getContext().getSession().get("USER_IN_SESSION");
		if(object == null){
			return Action.LOGIN;
		}		
		return invocation.invoke();//放行
	}

}
