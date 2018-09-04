package com.lixiaozhuo._04_process;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

//获取进程数据-编译和运行java代码
public class ProcessDemo {
	public static void main(String[] args) throws Exception {
		String str = "System.out.println(\"abcdef\")";
		eval(str);
	}

	public static void eval(String str) throws Exception {
		//使用StringBuilder拼接一个完整的hellword程序
		StringBuilder sBuilder = new StringBuilder(80);
		sBuilder.append("public class Hello{");
		sBuilder.append("public static void main(String[] args){");
		sBuilder.append(str);
		sBuilder.append(";");
		sBuilder.append("}");
		sBuilder.append("}");
		System.out.println(sBuilder);
		OutputStream out = new FileOutputStream("Hello.java");
		out.write(sBuilder.toString().getBytes());
		out.close();
		//调用javac进程来编译hello.java
		Process javacProcess = Runtime.getRuntime().exec("java Hello.class");

		//读取javac进程的错误流信息
		InputStream error = javacProcess.getErrorStream();
		byte[] buffer = new byte[1024];
		int len = -1;
		while ((len = error.read(buffer)) != -1) {
			String msg = new String(buffer, 0, len);
			System.out.println(msg);
		}
		error.close();
		//调用java进程来编译hello.java
		Process javaProcess = Runtime.getRuntime().exec("java Hello.class");

		//读取java进程的流信息
		InputStream info = javaProcess.getInputStream();
		while ((len = info.read(buffer)) != -1) {
			String msg = new String(buffer, 0, len);
			System.out.println(msg);
		}
		info.close();
		new File("Hello.java").delete();
		new File("Hello.class").delete();
	}
}
