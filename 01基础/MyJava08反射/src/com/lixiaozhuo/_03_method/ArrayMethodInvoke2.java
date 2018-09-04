package com.lixiaozhuo._03_method;

import java.lang.reflect.Method;

class User1 {
	public User1() {
		System.out.println("无参构造器");
	}

	public User1(String name) {
		System.out.println("构造器:name = " + name);
	}

	public User1(String name, String password) {
		System.out.println("构造器:name = " + name + "password = " + password);
	}

	public void doWork() {
		System.out.println("User.doWork()");
	}

	public void doWork(String... name) {
		System.out.println("User.doWork(name)");
	}

	public void doWork(String name, int... age) {
		System.out.println("User.doWork(name,age)");
	}
}

//数组参数的方法调用
public class ArrayMethodInvoke2 {
	public static void main(String[] args) throws Exception{
		Class<?> clz = User1.class;
		Method method = clz.getMethod("doWork",String.class, int[].class);
		method.invoke(clz.newInstance(), new Object[] { "sss", new int[] { 1, 2, 3 } });
		method = clz.getMethod("doWork", String[].class);
		method.invoke(clz.newInstance(), (Object) new String[] { "aa", "bb" });
	}
}
