package com.lixiaozhuo._03_file_stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

//正确关闭资源
public class CloseDemo {
	public static void main(String[] args) {
		test2();
	}

	public static void test1() {
		File file1 = new File("file/Stream.txt");
		File file2 = new File("file/Stream1.txt");
		try (InputStream in = new FileInputStream(file1); OutputStream out = new FileOutputStream(file2);) {
			byte[] buffer = new byte[5];
			int len = -1;
			while ((len = in.read(buffer)) != -1) {
				out.write(buffer, 0, len);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void test2() {
		File file1 = new File("file/Stream.txt");
		File file2 = new File("file/Stream1");
		InputStream in = null;
		OutputStream out = null;
		try {
			in = new FileInputStream(file1);
			out = new FileOutputStream(file2);
			byte[] buffer = new byte[5];
			int len = -1;
			while ((len = in.read(buffer)) != -1) {
				out.write(buffer, 0, len);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try
			{
				if(in != null){
					in.close();
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			try
			{
				if(out != null){
					out.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
		}
	}
}
