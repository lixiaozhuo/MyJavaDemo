package com.lixiaozhuo._08_memory_stream;

import java.io.CharArrayReader;
import java.io.CharArrayWriter;

//字符内存流/数组流
public class CharArrayStreamDemo {
	public static void main(String[] args) throws Exception {
		//字符数组输出流
		CharArrayWriter bos = new CharArrayWriter();
		bos.write("abd".toCharArray());
		char[] buffer = bos.toCharArray();
		//字符数组输入流
		CharArrayReader bis = new CharArrayReader(buffer);
		char[] bys = new char[1024];
		int len = -1;
		while ((len = bis.read(bys)) != -1) {
			System.out.println(new String(bys, 0, len));
		}
	}
}
