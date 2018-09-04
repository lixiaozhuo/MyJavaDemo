package com.lixiaozhuo._05_file_writer;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;

//字符输入流
public class FileReadDemo {
	public static void main(String[] args) throws Exception {
		File srcFile = new File("file/Stream.txt");
		Reader in = new FileReader(srcFile);
		int len = -1;
		while ((len = in.read()) != -1) {
			System.out.println((char)len);
		}
		in.close();
	}
}
