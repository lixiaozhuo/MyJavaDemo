package com.lixiaozhuo._01_input;

import java.io.Console;

//只能适合用于控制台,不能再Eclipse工具中使用
public class ConsoleDemo {

	public static void main(String[] args) {
		Console console = System.console();
		//读取用户输入的一行数据
		String line = console.readLine();
		System.out.println("读入的数据:" + line);
	}

}
