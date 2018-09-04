package com.lixiaozhuo._08_interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import lombok.Setter;

//自定义检查登录拦截器
public class CheckLogonInterceptor extends AbstractInterceptor{

	private static final long serialVersionUID = 1L;

	@Setter
	private String view;
	
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("执行拦截器");
		
		Object object = invocation.getInvocationContext().getSession().get(view);
		System.out.println(object);
		if(object == null){
			return "input";		
		}	
		return invocation.invoke();//放行
	}

}
