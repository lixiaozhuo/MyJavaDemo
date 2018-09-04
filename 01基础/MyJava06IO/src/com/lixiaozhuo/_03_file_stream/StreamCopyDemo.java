package com.lixiaozhuo._03_file_stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

//使用字节流完成文件拷贝
public class StreamCopyDemo {
	public static void main(String[] args) throws Exception {
		File file1 = new File("file/Stream.txt");
		File file2 = new File("file/Stream1.txt");
		InputStream in = new FileInputStream(file1);
		OutputStream out = new FileOutputStream(file2);
		byte[] buffer = new byte[5];
		int len = -1;
		while((len = in.read(buffer))!=-1){
			out.write(buffer, 0, len);
		}
		
		in.close();
		out.close();
		
	}
}
 