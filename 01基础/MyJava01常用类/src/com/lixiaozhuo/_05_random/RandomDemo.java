package com.lixiaozhuo._05_random;

import java.util.Random;

//Random获取随机数
public class RandomDemo {
	public static void main(String[] args) {
		Random ra = new Random(10);
		System.out.println(ra.nextBoolean());
		System.out.println(ra.nextDouble());
		System.out.println(ra.nextInt());
		System.out.println(ra.nextInt(100));
		System.out.println("-------------------------------");
		Random rb = new Random(2);
		System.out.println(rb.nextBoolean());
		System.out.println(rb.nextDouble());
		System.out.println(rb.nextInt());
		System.out.println(rb.nextInt(100));
		System.out.println("-------------------------------");
	}
}
