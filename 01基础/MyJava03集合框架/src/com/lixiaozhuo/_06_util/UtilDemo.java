package com.lixiaozhuo._06_util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class UtilDemo {
	@SuppressWarnings({ "unused", "unchecked" })
	public static void main(String[] args) {
		//得到的是Arrays类中的内部类对象.
		List<String> list = Arrays.asList("a","b","c");
		System.out.println(list);
		//不可以删除
		//list.remove(0);
		
		//得到空集
		List<String> list1 = new ArrayList<>();//java7开始
		List<String> list2 = Collections.EMPTY_LIST;
		List<String> list3 = Collections.emptyList();
		
		//设置list线程安全
		list = Collections.synchronizedList(list);
	}
}
