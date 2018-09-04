package com.lixiaozhuo._02_constructor;

import java.lang.reflect.Constructor;

//使用反射调用构造器
public class GreatObjectDemo {
	public static void main(String[] args) throws Exception{
		//获取构造器所在类的字节码对象
		Class<User> clz = User.class;
		//获取类的一个无参构造器
		Constructor<User> cs  = clz.getDeclaredConstructor();	
		//设置构造器的可访问
		cs.setAccessible(true);
		//调用newInstance()方法创建对象,并传入实参
		cs.newInstance();
		
		//使用类字节码对象调用类的无参构造器,无参构造器需public修饰
		clz.newInstance();
		
	}
}
