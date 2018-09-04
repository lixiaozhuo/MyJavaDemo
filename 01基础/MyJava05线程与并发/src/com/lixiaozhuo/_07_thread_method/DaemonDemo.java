package com.lixiaozhuo._07_thread_method;

//后台线程
public class DaemonDemo {
	public static void main(String[] args) {
		//主线程不是后台线程
		System.out.println(Thread.currentThread().isDaemon());
	}
}
