package com.lixiaozhuo._05_random;

import java.util.concurrent.ThreadLocalRandom;

//ThreadLocalRandom获取随机数
public class ThreadLocalRandomDemo {
	public static void main(String[] args) {
		ThreadLocalRandom random = ThreadLocalRandom.current();
		System.out.println(random.nextDouble(100, 200));
	}
}
