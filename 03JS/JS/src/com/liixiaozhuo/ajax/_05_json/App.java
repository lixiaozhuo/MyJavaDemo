package com.liixiaozhuo.ajax._05_json;

import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.liixiaozhuo.ajax._04_linkage.Province;

public class App {
	//Jackson测试
	@Test
	public void testJackson() throws Exception {
		//创建转换对象
		ObjectMapper mapper = new ObjectMapper();
		//转换单个对象为字符串
		System.out.println(mapper.writeValueAsString(Province.getAllProvince().get(0)));
		//转换多个对象为字符串
		System.out.println(mapper.writeValueAsString(Province.getAllProvince()));
		//Map对象转换为字符串
		Map<String,String> map = new HashMap<>();
		map.put("aa", "aa");
		map.put("bb","bb");
		System.out.println(mapper.writeValueAsString(map));
	}
	
	//FastJson测试
	@Test
	public void testFastJson() throws Exception {
		//转化单个对象为字符串
		System.out.println(JSON.toJSONString(Province.getAllProvince().get(0)));
		//转换多个对象为字符串
		System.out.println(JSON.toJSONString(Province.getAllProvince()));
		//Map对象转换为字符串
		Map<String,String> map = new HashMap<>();
		map.put("aa", "aa");
		map.put("bb","bb");
		System.out.println(JSON.toJSONString(map));
	}
}
