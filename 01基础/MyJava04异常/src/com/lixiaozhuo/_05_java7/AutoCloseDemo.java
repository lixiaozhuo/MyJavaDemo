package com.lixiaozhuo._05_java7;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

//java7自动资源关闭
public class AutoCloseDemo {
	public static void main(String[] args) {
		test1();
		test2();
	}

	//java7֮之前的手动资源关闭
	private static void test1() {
		OutputStream out = null;
		try {
			//打开资源对象
			out = new FileOutputStream("C:\\file\\1.txt");
			//操作资源对象
			out.write(1);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {			
			if (out != null) {
				//关闭资源
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	//java7自动资源关闭
	private static void test2() {
		//打开资源对象,存放在这里的资源类必须实现java.lang.AutoCloseable接口
		try (OutputStream out = new FileOutputStream("C:\\file\\1.txt");) {
			//可能出现异常的代码
			out.write(1);
		} catch (Exception e) {
			//处理异常
			e.printStackTrace();
		}
	}
}
