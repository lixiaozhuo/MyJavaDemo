package com.lixiaozhuo.el;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class User {
	private Long id;
	private String name;
	private String[] hobby;
	private List<Integer> list;
	private Map<String,String> map;
	public User(){
		id = 10L;
		name = "lxz";
		hobby = new String[]{"java","c#","js"};
		list = Arrays.asList(1,2,3,4);
		map = new HashMap<>();
		map.put("com.lixiaozhuo","a");
		map.put("b","b");
		map.put("c","c");		
	}
}
