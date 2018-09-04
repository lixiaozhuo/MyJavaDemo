package com.lixiaozhuo._05_file_writer;

import java.util.Arrays;

//编码解码
public class EncodingDemo {
	public static void main(String[] args) throws Exception {
		String msg  = "aww外国";
		byte[] data = msg.getBytes("UTF-8");
		System.out.println(Arrays.toString(data));
		
		//服务器都是外国人写的,外国人解码使用自己的ISO-8859-1
		String ret = new String(data,"ISO-8859-1");
		System.out.println(ret);
		//对于中国人来说,乱码
		//解决方案 
		data = ret.getBytes("ISO-8859-1");
		System.out.println(Arrays.toString(data));
		ret = new String(data,"UTF-8");
		System.out.println(ret);
	}
}
