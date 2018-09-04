package com.lixiaozhuo._03_method;

import java.lang.reflect.Method;

//方法实现
public class MethodInvokeDemo {
	public static void main(String[] args) throws Exception {
		//获取类的字节码对象
		Class<User> clz = User.class;
		//获取类的方法
		Method method = clz.getDeclaredMethod("doWork", String.class, int.class);
		System.out.println(method);
		//设置方法可访问
		method.setAccessible(true);
		//执行方法
		Object obj = method.invoke(clz.newInstance(), "", 18);
		System.out.println(obj);
	}
}
