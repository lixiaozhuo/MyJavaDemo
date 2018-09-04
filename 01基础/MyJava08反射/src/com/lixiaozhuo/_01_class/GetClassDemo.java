package com.lixiaozhuo._01_class;

//获取类的字节码对象
public class GetClassDemo {

	public static void main(String[] args) throws Exception {
		//方式1 通过类的class属性
		Class<java.util.Date> clz1 = java.util.Date.class;
		//方式2 通过对象那个的getClass方法
		java.util.Date date = new java.util.Date();
		Class<?> clz2 = date.getClass();
		//方式3 通过Class类的静态方法forName(String clasName)
		Class<?> clz3 = Class.forName("java.util.Date");

		System.out.println(clz1);
		System.out.println(clz2);
		System.out.println(clz3);

	}
}
