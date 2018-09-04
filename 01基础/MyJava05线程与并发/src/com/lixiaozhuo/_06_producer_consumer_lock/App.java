package com.lixiaozhuo._06_producer_consumer_lock;

//测试代码
public class App {
	public static void main(String[] args) {
		//生产者和消费者共同的资源对象
		ShareResource resource = new ShareResource();
		//启动生产者线程
		new Thread(new Producer(resource)).start();
		//启动消费者线程
		new Thread(new Consumer(resource)).start();
	}
}

