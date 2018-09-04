package com.lixiaozhuo._05_producer_consumer;

//消费者
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

