package com.lixiaozhuo._05_producer_consumer;

//测试代码
public class Test {
	public static void main(String[] args) {
		//生产者和消费者共同的资源对象
		ShareResource resource = new ShareResource();
		//启动生产者线程
		new Thread(new Producer(resource)).start();
		//启动消费者线程
		new Thread(new Consumer(resource)).start();
	}
}

