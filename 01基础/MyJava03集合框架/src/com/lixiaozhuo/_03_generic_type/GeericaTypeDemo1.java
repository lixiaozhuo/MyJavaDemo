package com.lixiaozhuo._03_generic_type;

import java.util.ArrayList;
import java.util.List;

//泛型擦除
public class GeericaTypeDemo1 {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		List<Integer> list1 = new ArrayList<>();
		list1.add(123);

		List list2 = null;
		list2 = list1;// 泛型被擦除
		list2.add("abc");

		List<String> list3 = null;
		list3 = list2;
		//String str = 123;
		String str = list3.get(0);
		System.out.println(str);
	}
}
