package com.lixiaozhuo._05_file_writer;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;

//字符输出流
public class FileWriteDemo {
	public static void main(String[] args) throws Exception {
		File srcFile = new File("file/Stream.txt");
		Writer out = new FileWriter(srcFile,true);
		
		out.write("王");
		out.write("等多家".toCharArray(),1,2);
		out.write("abs");
		
		//out.flush();
		out.close();
	}
}
