package com.lixiaozhuo._08_memory_stream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

//字节的数组流/内存流
public class ByteArrayStreamDemo {
	public static void main(String[] args) throws Exception {
		//字节数组输出流
		ByteArrayOutputStream bos = new ByteArrayOutputStream();		
		bos.write("abd".getBytes());
		byte [] buffer = bos.toByteArray();
		//字节数组输入流
		ByteArrayInputStream bis = new ByteArrayInputStream(buffer);
		byte [] bys = new byte[1024];
		int len = -1;
		while((len = bis.read(bys)) != -1){
			System.out.println(new String(bys,0,len));
		}		
	}
}
