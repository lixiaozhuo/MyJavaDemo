package com.lixiaozhuo._04_set;

import java.util.TreeSet;

//TreeSet
public class TreeSetDemo1 {
	public static void main(String[] args) {
		TreeSet<String> set = new TreeSet<>();
		set.add("Y");
		set.add("D");
		set.add("1");
		set.add("2");
		set.add("4");
		set.add("3");
		set.add("A");
		set.add("a");
		System.out.println(set);
		System.out.println(set.first());// 最小值
		System.out.println(set.last());// 最大值
		System.out.println(set.headSet("4"));// 返回此 set 的部分视图，其元素严格小于 toElement。
	}
}
