package com.lixiaozhuo._04_javabean;

import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

//演示BeanUtils工具
public class BeanUtilsDemo {
	public static void main(String[] args) throws Exception{
		Object person = new Person("aa", 10);
		Map<String,String> map = BeanUtils.describe(person);
		System.out.println("map = " + map);
		//获取对象的属性
		System.out.println("age = " + BeanUtils.getProperty(person, "age"));
		//对象设置属性
		BeanUtils.setProperty(person, "age", "20");
		System.out.println("person = " + person);
		//把Map的数据Key = Value转到JavaBean中
		Object obj = new Person();
		map.put("age","30");		
		BeanUtils.copyProperties(obj,map);
		System.out.println("obj = " + obj);
	}
		
}
