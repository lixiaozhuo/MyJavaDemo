package com.lixiaozhuo._02_constructor;

import java.lang.reflect.Constructor;

class User {
	public User() {
		System.out.println("无参构造器");
	}

	protected User(String name) {
		System.out.println("构造器 :name = " + name);
	}

	@SuppressWarnings("unused")
	private User(String name, String password) {
		System.out.println("构造器:name = " + name + "password = " + password);
	}
}

//获取构造器
public class GetClassConstructorDemo {
	public static void main(String[] args) throws Exception {
		//获取构造器所在类的字节码对象
		Class<User> clz = User.class;
		getAllConstructor(clz);
		getOneConstructor(clz);
	}

	//获取类对象所有的构造器
	public static void getAllConstructor(Class<User> clz) {
		//获取类对象中的所有构造器,只能获取public修饰的构造器
		System.out.println("获取所有public修饰的构造器");
		Constructor<?>[] cs = clz.getConstructors();
		for (Constructor<?> cs1 : cs) {
			System.out.println(cs1);
		}
		//获取类对象中所有的构造器,不区分修饰符
		System.out.println("获取所有构造器,不区分修饰符");
		cs = clz.getDeclaredConstructors();
		for (Constructor<?> cs1 : cs) {
			System.out.println(cs1);
		}
	}

	//获取类对象获取一个构造器
	public static void getOneConstructor(Class<User> clz) throws Exception {
		//获取类对象中的一个public修饰的构造器
		System.out.println("获取一个public修饰的无参构造器");
		Constructor<User> cs = clz.getConstructor();
		System.out.println(cs);
		//获取类对象中一个的构造器,不区分修饰符
		System.out.println("获取一个无参构造器,不区分修饰符");
		cs = clz.getDeclaredConstructor();
		System.out.println(cs);
	}
}
