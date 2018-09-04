package com.lixiaozhuo._05_map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

//Map Set List组合适用
public class MapDemo2 {
	public static void main(String[] args) {
		Set<String> names1 = new HashSet<>();
		names1.add("一");
		names1.add("二");
		names1.add("三");
		Set<String> names2 = new HashSet<>();
		names2.add("A");
		names2.add("B");
		names2.add("C");
		Map<String,Set<String>> classMap1 = new HashMap<>();
		classMap1.put("汉字", names1);
		classMap1.put("字母", names2);
		Map<String,Set<String>> classMap2 = new HashMap<>();
		classMap2.put("汉字", names1);
		classMap2.put("字母", names2);
		
		List<Map<String,Set<String>>> school = new ArrayList<>();
		school.add(classMap1);
		school.add(classMap2);
		System.out.println(school);
		
		
		
	}

}
