package com.lixiaozhuo._06_load_file;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

//加载资源文件
public class LoadFileDemo {
	public static void main(String[] args) throws Exception {
		test1();
		test2();
		test3();
	}

	//使用绝对路径方式加载
	private static void test1() throws Exception {
		Properties p = new Properties();
		InputStream inStream = new FileInputStream("C:/Users/LXZ/workspace/MyJava反射/resourses/db.properties");
		//加载输入流
		p.load(inStream);
		System.out.println(p);
	}

	//使用相对路径方式加载 相对于classpath的根路径(字节码输出目录)
	private static void test2() throws Exception {
		Properties p = new Properties();
		//ClassLoader loader = LoadFileDemo.class.getClassLoader();
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		InputStream inStream = loader.getResourceAsStream("db.properties");
		//加载输入流
		p.load(inStream);
		System.out.println(p);
	}
	
	//使用相对路径,相对于当前加载资源文件的字节码对象
	private static void test3() throws Exception {
		Properties p = new Properties();
		InputStream inStream = LoadFileDemo.class.getResourceAsStream("db.properties");
		//加载输入流
		p.load(inStream);
		System.out.println(p);
	}
}
