package com.lixiaozhuo._10_print_stream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;

//字符打印流
public class PrintWriteDemo {
	public static void main(String[] args) throws Exception {
		PrintWriter pw = new PrintWriter(new FileOutputStream(new File("file/Stream.txt")));
		
		pw.println("aaaa");
		pw.close();
	}
	
}
