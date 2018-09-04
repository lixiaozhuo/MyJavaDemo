package com.lixiaozhuo._05_file_writer;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;

//通过字符流复制文件
public class FileCopyDemo {
	public static void main(String[] args) throws Exception {
		File srcFile = new File("file/Stream.txt");
		File destFile = new File("file/Stream1.txt");
		Reader in = new FileReader(srcFile);
		Writer out = new FileWriter(destFile);
		char[] buffer = new char[1024];
		int len = -1;
		while ((len = in.read(buffer)) != -1) {
			out.write(buffer, 0, len);
		}

		in.close();
		out.close();
	}
}
