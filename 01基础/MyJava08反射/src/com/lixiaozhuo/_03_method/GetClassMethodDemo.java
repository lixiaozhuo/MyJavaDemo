package com.lixiaozhuo._03_method;

import java.lang.reflect.Method;

class User {
	public void doWork() {
		System.out.println("User.doWork()");
	}

	public void doWork(String name) {
		System.out.println("User.doWork(name)");
	}

	@SuppressWarnings("unused")
	private String doWork(String name, int age) {
		System.out.println("User.doWork(name,age)");
		return "name = " + name + "age = " + age;
	}
}

//利用反射得到类的方法
public class GetClassMethodDemo {
	public static void main(String[] args) throws Exception {
		//获取类的字节码对象
		Class<User> clz = User.class;
		//allMethod(clz);
		oneMethod(clz);
	}

	public static void allMethod(Class<User> clz) {
		//获取包括自身和继承过来的所有的public方法
		Method[] methods = clz.getMethods();
		for (Method m : methods) {
			System.out.println(m);
		}
		System.out.println("---------------------");
		//获取自身类中所有方法(不包括继承的和访问权限无关)
		methods = clz.getDeclaredMethods();
		for (Method m : methods) {
			System.out.println(m);
		}
	}
	
	public static void oneMethod(Class<User> clz) throws Exception{
		//获取包括自身和继承过来的一个public方法
		Method method = clz.getMethod("doWork",String.class);
		System.out.println(method);
		System.out.println("---------------------");
		//获取自身类中一个方法(不包括继承的和访问权限无关)
		method = clz.getDeclaredMethod("doWork",String.class,int.class);
		System.out.println(method);
	}
}
