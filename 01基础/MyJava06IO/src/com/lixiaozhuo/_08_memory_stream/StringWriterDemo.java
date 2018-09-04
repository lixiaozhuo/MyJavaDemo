package com.lixiaozhuo._08_memory_stream;

import java.io.StringReader;
import java.io.StringWriter;

//字符串流/字符串的内存流
public class StringWriterDemo {
	public static void main(String[] args) throws Exception {
		//字符串输出流
		StringWriter strW = new StringWriter();
		strW.write("ABC");
		System.out.println(strW);
		//字符串输入流
		StringReader strR = new StringReader("aaaa");
		char[] buffer = new char[1024];
		int len = -1;
		while ((len = strR.read(buffer)) != -1) {
			System.out.println(new String(buffer, 0, len));
		}
	}
}
