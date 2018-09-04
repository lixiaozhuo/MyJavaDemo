package com.lixiaozhuo._05_map;

import java.util.Map;
import java.util.TreeMap;

//计算一个字符串,每一个字符出现的次数
public class MapDemo1 {
	public static void main(String[] args) {
		String str = "abddjsjjjsdjgakjadgggggg";
		char[] arr = str.toCharArray();
		Map<Character,Integer> map = new TreeMap<>();
		for(char ch : arr){
			if(map.containsKey(ch)){
				Integer i = map.get(ch);
				i++;
				map.put(ch, i);
			}else{
				map.put(ch,1);
			}
		}
		System.out.println(map);
	}
}
