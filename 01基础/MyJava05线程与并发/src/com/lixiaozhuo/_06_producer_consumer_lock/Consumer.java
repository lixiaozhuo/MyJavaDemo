package com.lixiaozhuo._06_producer_consumer_lock;

public class Consumer implements Runnable {
	//共享的资源对象
	private ShareResource resourse = null;

	public Consumer(ShareResource resourse) {
		this.resourse = resourse; 
	}

	public void run() {
		for (int i = 0; i < 50; i++) {
			resourse.popup();
		}
	}

}

