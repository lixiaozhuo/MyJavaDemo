package com.lixiaozhuo._05_map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

//HashMap
public class HashMapDemo {
	public static void main(String[] args) {
		Map<String,String> map = new HashMap<>();
		map.put("key1", "value1");
		map.put("key2", "value2");
		map.put("key3", "value3");
		map.put("key4", "value4");
		map.put("key5", "value5");
		map.put("key5", "value3");
		System.out.println(map);
		// map.clear();
		// System.out.println(map);
		System.out.println(map.containsKey("key1"));
		System.out.println(map.containsValue("key1"));
		
		
		Object val = map.get("key1");
		System.out.println(val);
		
		//获取Map中所有key所组成的集合(Key是不能重复的,类似于Set)
		Set<String> set = map.keySet();
		for(String key : set){
			System.out.println(key);
		}
		
		//获取Map中所有Value所组成的集合(Value可以重复,类似于List)
		Collection<String> co = map.values();
		for(Object value : co){
			System.out.println(value);
		}
		
		//获取Map中所有的Entry(key-value)
		Set<Map.Entry<String, String>> set1 = map.entrySet();
		for(Map.Entry<String, String> entry : set1){
			System.out.println(entry);
			String key = entry.getKey();//获取键
			String value = entry.getValue();//获取值
			System.out.println(key + "<->" + value);
		}
		
		
	}
}
