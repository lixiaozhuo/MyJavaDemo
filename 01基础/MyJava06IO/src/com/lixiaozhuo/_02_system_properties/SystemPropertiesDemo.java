package com.lixiaozhuo._02_system_properties;

import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

//系统属性
public class SystemPropertiesDemo {
	public static void main(String[] args) {
		   Properties pro = System.getProperties();
		   Set<Entry<Object ,Object>> entrySet = pro.entrySet();
		   for(Entry<Object,Object> entry : entrySet){
			   System.out.println(entry.getKey() + " = " + entry.getValue());
		   }
		   //获取当前项目路径
		   System.out.println(System.getProperty("user.dir"));
		   
		   
	}
}
