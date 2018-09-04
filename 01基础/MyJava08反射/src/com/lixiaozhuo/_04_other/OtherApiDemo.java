package com.lixiaozhuo._04_other;

import java.lang.reflect.Modifier;

public class OtherApiDemo {
	public static void main(String[] args) {
		//获取类的修饰符
		Class<OtherApiDemo> clz = OtherApiDemo.class;
		int mod = clz.getModifiers();
		System.out.println("mod = " + mod);
		System.out.println("mod = " + Modifier.toString(mod));
		
		//获取类的名称
		System.out.println("全限定名 = " + clz.getName());
		System.out.println("简单名称 = " + clz.getSimpleName());
		
		//获取类的包名
		System.out.println("包名 = " + clz.getPackage());
		
		//获取类的父类
		System.out.println("父类 = " + clz.getSuperclass());
	}
}
