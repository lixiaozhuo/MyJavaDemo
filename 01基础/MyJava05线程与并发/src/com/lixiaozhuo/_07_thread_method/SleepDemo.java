package com.lixiaozhuo._07_thread_method;

//线程休眠
public class SleepDemo {
	public static void main(String[] args) throws InterruptedException {
		for (int i = 10; i > 0; i--) {
			System.out.println("还剩" + i + "秒");
			Thread.sleep(1000);
		}
		System.out.println("爆炸");
	}
}
