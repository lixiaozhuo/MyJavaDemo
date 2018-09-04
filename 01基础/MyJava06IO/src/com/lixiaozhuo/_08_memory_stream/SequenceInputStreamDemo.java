package com.lixiaozhuo._08_memory_stream;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.SequenceInputStream;

//合并流/顺序流------就是把多个输入流,合并成一个流对象.
public class SequenceInputStreamDemo {
	public static void main(String[] args) throws Exception {
		InputStream input1 = new FileInputStream("file/Stream.txt");
		InputStream input2 = new FileInputStream("file/Stream1.txt");
		SequenceInputStream in = new SequenceInputStream(input1, input2);
		byte[] buffer = new byte[1024];
		int len = -1;
		while ((len = in.read(buffer)) != -1) {
			System.out.println(new String(buffer, 0, len));
		}
		input1.close();
		input2.close();
		in.close();
	}
}
