package com.lixiaozhuo._06_buffer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

//字节缓冲流
public class BufferedWriterDemo {
	public static void main(String[] args) throws Exception {
		BufferedWriter out = new BufferedWriter(new FileWriter("file/Stream.txt"));
		out.write("bcd");
		out.newLine();
		out.write("abc");
		out.close();
		
		BufferedReader in = new BufferedReader(new FileReader("fileStream.txt"));
		String str  = null;
		while((str = in.readLine()) != null){
			System.out.println(str);
		}
		in.close();
		
	}
}
