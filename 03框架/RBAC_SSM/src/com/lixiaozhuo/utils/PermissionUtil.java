package com.lixiaozhuo.utils;

import java.lang.reflect.Method;

//权限工具类
public class PermissionUtil {
	private PermissionUtil(){}
	
	/**
	 * 生成权限表达式
	 * @param method 方法
	 * @return 权限表达式
	 */
	public static String buildPermissionExpression(Method method){
		String className = method.getDeclaringClass().getName();
		String methodName = method.getName();
		return className + ":" + methodName;
	}
}
