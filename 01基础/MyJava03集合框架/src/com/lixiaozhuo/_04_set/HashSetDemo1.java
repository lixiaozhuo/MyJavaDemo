package com.lixiaozhuo._04_set;

import java.util.HashSet;
import java.util.Set;

//HashSet
public class HashSetDemo1 {
	public static void main(String[] args) {
		Set<String> set = new HashSet<>();
		set.add("a");
		set.add("1");
		set.add("c");
		set.add("b");
		set.add("d");
		set.add("o");
		set.add("1");
		System.out.println(set);
	}
}
