package com.lixiaozhuo._07_thread_method;

class PriorityThread extends Thread {
	public PriorityThread(String name) {
		super(name);
	}

	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println(super.getName() + "-" + i);
		}
	}
}

//线程优先级
public class PriorityDemo {
	public static void main(String[] args) {
		//设置主线程优先级
		Thread.currentThread().setPriority(10);
		//获取主线程优先级
		System.out.println(Thread.currentThread().getPriority());

		PriorityThread max = new PriorityThread("高优先级");
		max.setPriority(Thread.MAX_PRIORITY);
		PriorityThread min = new PriorityThread("低优先级");
		min.setPriority(Thread.MIN_PRIORITY);
		max.start();
		min.start();

	}
}
