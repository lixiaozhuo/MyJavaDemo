package com.lixiaozhuo._01_class;

//其他数据类型类实例
public class GetDataTypeClassDemo {
	public static void main(String[] args) {
		//8大基本数据类型Class实例
		Class<Boolean> booleanClass = boolean.class;
		Class<?> intClass = int.class;
		Class<?> voidClass = void.class;
		System.out.println("boolean.class = " + booleanClass);
		System.out.println("int.class = " + intClass);
		System.out.println("void.class = " + voidClass);
		//包装类和基本数据类型  是不同的数据类型
		System.out.print("Integer.class == int.class结果为");
		System.out.println(Integer.class == int.class);
		//8大基本数据类型的包装类中常量TYPE,返回包装类对应基本类型的数据类型
		System.out.println("Integer.TYPE = " + Integer.TYPE);

		//数组的Class实例
		int[] arr1 = new int[] { 1, 2, 3 };
		Class<?> arr1Class = arr1.getClass();
		System.out.println("arr1Class = " + arr1Class);
		Class<int[]> arr2Class = int[].class;
		System.out.println("arr2Class = " + arr2Class);
	}
}
