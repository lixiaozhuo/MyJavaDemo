package com.lixiaozhuo._13_properties;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

//加载资源对象
public class LoadPropertiesDemo {
	public static void main(String[] args) throws Exception {
		Properties p = new Properties();
		InputStream inStream = new FileInputStream("C:/Users/LXZ/workspace/MyJavaIO/resources/db.properties");
		//加载输入流中的数据,加载之后,数据在p对象
		p.load(inStream);
		System.out.println(p);
	}
}
