package com.lixiaozhuo._07_transform_stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

//转换流使用
public class StreamCopyDemo {
	public static void main(String[] args) throws Exception {
		File file1 = new File("file/Stream.txt");
		File file2 = new File("java/Stream1.txt");
		
		Reader in = new InputStreamReader(new FileInputStream(file1),"GBK");
		Writer out = new OutputStreamWriter(new FileOutputStream(file2),"GBK");
		
		char[] buffer = new char[1024];
		int len = -1;
		while((len = in.read(buffer))!=-1){
			out.write(buffer, 0, len);
		}
		
		in.close();
		out.close();
		
	}
}
 