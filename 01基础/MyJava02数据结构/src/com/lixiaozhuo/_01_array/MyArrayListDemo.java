package com.lixiaozhuo._01_array;

//自定义数组集合测试
public class MyArrayListDemo {
	public static void main(String[] args) {
		MyArrayList list = new MyArrayList();
		System.out.println(list.isEmpty());
		list.add("a");
		list.add(1);
		list.add(true);
		System.out.println(list);
		list.delete(0);
		System.out.println(list);
		System.out.println(list.isEmpty());
	}
}
