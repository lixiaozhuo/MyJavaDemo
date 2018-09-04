package com.lixiaozhuo._06_buffer;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

//字节缓冲流
public class BufferedStreamDemo {
	public static void main(String[] args) throws Exception {
		//字节缓存输出流
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("file/Stream.txt"));
		bos.write("hello".getBytes());
		bos.close();
		
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream("file/Stream.txt"));
		byte[] buffer = new byte[1024];
		int len = -1;
		while((len = bis.read(buffer)) != -1){
			System.out.println(new String(buffer,0,len));
		}
		bis.close();
	}
}
