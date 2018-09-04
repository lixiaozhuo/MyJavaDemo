package com.lixiaozhuo._05_map;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//Properties类
public class PropertiesDemo {
	public static void main(String[] args) throws IOException {
		//是Map的实现类  是Hashtable的子类
		Properties p = new Properties();
		//key和value都是String类
		p.setProperty("username", "root");
		p.setProperty("password", "admin");
		System.out.println(p);
		String val = p.getProperty("usernam","该key不存在时,返回的默认值");
		System.out.println(val);	
		//加载资源文件(IO)
		@SuppressWarnings("unused")
		InputStream inputStream = null;
		//p.load(inputStream);
	}
}
