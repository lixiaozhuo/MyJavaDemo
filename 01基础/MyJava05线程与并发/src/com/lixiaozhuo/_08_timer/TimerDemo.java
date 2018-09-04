package com.lixiaozhuo._08_timer;

import java.util.Timer;
import java.util.TimerTask;

//定时器
public class TimerDemo {
	public static void main(String[] args) {
		// 三秒后打印
		new Timer().schedule(new TimerTask() {
			public void run() {
				System.out.println("a");
			}
		}, 3000);
		//线程组
		System.out.println(Thread.currentThread().getThreadGroup());
	}
}
