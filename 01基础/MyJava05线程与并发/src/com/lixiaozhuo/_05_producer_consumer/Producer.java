package com.lixiaozhuo._05_producer_consumer;

//生产者
public class Producer implements Runnable {
	//共享的资源对象
	private ShareResource resourse = null;

	public Producer(ShareResource resourse) {
		this.resourse = resourse;
	}

	public void run() {
		for (int i = 0; i < 50; i++) {
			if (i % 2 == 0) {
				resourse.push("哥", "男");
			} else {
				resourse.push("姐", "女");
			}
		}
	}
}

