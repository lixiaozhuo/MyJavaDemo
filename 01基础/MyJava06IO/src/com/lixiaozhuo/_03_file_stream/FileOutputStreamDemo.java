package com.lixiaozhuo._03_file_stream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

//文件输出流
public class FileOutputStreamDemo {
	public static void main(String[] args) throws Exception {
		File file = new File("file/Stream.txt");
		OutputStream out = new FileOutputStream(file,true);
		out.write("abcde".getBytes());
		out.write(65);
		out.close();
	}
}
