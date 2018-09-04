package com.lixiaozhuo._03_file_stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

//文件输入流
public class FileInputStreamDemo {
	public static void main(String[] args) throws Exception {
		File file = new File("file/Stream.txt");
		InputStream in = new FileInputStream(file);
		int data = in.read();
		System.out.println(data);
		
		/*byte[] buffer = new byte [2];
		System.out.println(Arrays.toString(buffer));
		int ret = in.read(buffer);
		System.out.println(Arrays.toString(buffer));
		System.out.println(ret);*/
		
		byte[] buffer = new byte [5];
		int len = -1;
		while((len = in.read(buffer)) != -1){
			String str = new String(buffer, 0,len);
			System.out.println(str);
		}
		
		in.close();
	}
}
