package com.lixiaozhuo._03_extends_vs_implements;


//线程休眠
public class SleepDemo {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("begin-------");
		for (int i = 5; i >= 0; i--) {
			System.out.println("i=" + i);
			Thread.sleep(100);
		}
		System.out.println("end--------");
	}
}
