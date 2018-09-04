package com.lixiaozhuo._11_system_print;

import java.io.FileInputStream;
import java.io.PrintStream;

public class SystemPrintDemo {
	public static void main(String[] args) throws Exception {
		//重定向标准输入流
		System.setIn(new FileInputStream("file/out"));
		//重定向标准输出流
		System.setOut(new PrintStream("file/in"));
		System.out.println("begin");
		int age = System.in.read();
		System.out.println(age);
		System.out.println("end");
		
	}
}
