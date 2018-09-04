package com.lixiaozhuo._05_random;

import java.util.Random;
import java.util.UUID;

//获取5位的随机数
public class FiveRandowDemo {
	public static void main(String[] args) {
		System.out.println("UUID获取5位随机数:" + UUID.randomUUID().toString().substring(0, 5));
		System.out.println("------------------");
		String str = "ABCDEFGHIGKLMNOPQRSTUVWXYZ";
		str += str.toLowerCase();//小写字符串
		str += "123456789";//数字集合
		System.out.println(str);//数字字符集合
		StringBuilder strB = new StringBuilder(5);
		for (int i = 0; i < 5; i++) {
			char ch = str.charAt(new Random().nextInt(str.length()));//获取一个随机字符
			strB.append(ch);
		}
		System.out.println("5位的随机数" + strB);
	}
}
