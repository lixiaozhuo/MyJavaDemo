package com.lixiaozhuo.web.interceptor;

import java.lang.reflect.Method;
import java.util.Set;

import com.lixiaozhuo.domain.Employee;
import com.lixiaozhuo.utils.PermissionUtil;
import com.lixiaozhuo.utils.RequiredPermission;
import com.lixiaozhuo.utils.UserContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

//权限拦截器
public class SecruityInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		Employee currentUser = (Employee) invocation.getInvocationContext().getSession()
				.get(UserContext.USERINSESSION);
		//登录用户为超级管理员,放行
		if(currentUser.getAdmin()){
			return invocation.invoke();
		}
		//获取Action的class对象
		Class<?> clazz = invocation.getProxy().getAction().getClass();		
		//获取方法名字
		String methodName = invocation.getProxy().getMethod();
		//获取方法
		Method method = clazz.getMethod(methodName);
		//方法上没有RequiredPermission注解,放行
		if(!method.isAnnotationPresent(RequiredPermission.class)){
			return invocation.invoke();
		}
		//获取方法对应的权限
		String permissionExpression = PermissionUtil.buildPermissionExpression(method);
		//获取session中的用户权限
		@SuppressWarnings("unchecked")
		Set<String> permissions = (Set<String>) invocation
				.getInvocationContext().getSession()
				.get(UserContext.PERMISSIONINSESSION);
		if(permissions.contains(permissionExpression)){
			return invocation.invoke();
		}
		return "nopermission";
	}

}
