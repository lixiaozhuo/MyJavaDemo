package com.lixiaozhuo._03_encoding;

import java.net.URLDecoder;
import java.net.URLEncoder;

//URL编码解码
public class EncodingDemo {
	public static void main(String[] args) throws Exception {
		System.out.println(System.getProperty("file.encoding"));
		String name = "王阿价格大概爱上我";
		String ret = URLEncoder.encode(name, "UTF-8");
		System.out.println(ret);
		String msg = URLDecoder.decode(ret, "UTF-8");
		System.out.println(msg);
	}
}
