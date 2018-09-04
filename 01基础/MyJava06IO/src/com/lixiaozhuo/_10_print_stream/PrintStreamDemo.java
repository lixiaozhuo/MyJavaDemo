package com.lixiaozhuo._10_print_stream;

import java.io.File;
import java.io.PrintStream;
//字节打印流
public class PrintStreamDemo {
	public static void main(String[] args) throws Exception {
		PrintStream pr = new PrintStream(new File("file/Stream.txt"));
		pr.write("abc".getBytes());
		pr.println("true");
		pr.println(17);
		pr.println("5");
		pr.close();
	}
}
