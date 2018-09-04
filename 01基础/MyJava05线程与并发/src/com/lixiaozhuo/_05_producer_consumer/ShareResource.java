package com.lixiaozhuo._05_producer_consumer;

//共享资源对象（姓名-性别）
public class ShareResource {
	private String name;
	private String gender;
	private boolean isEmpty = true;// 表示共享资源对象是否为空

	/**
	 * 生产者向共享资源对象存储数据
	 * 
	 * @param name
	 *            存储的姓名
	 * @param gender
	 *            存储的性别
	 */
	synchronized public void push(String name, String gender) {
		try {
			while (!isEmpty) {// 共享资源不空，等待消费者消费
				// 使用同步锁对象来调用，表示当前线程释放同步锁，进入等待池，只能被其他线程所唤醒
				this.wait();
			}
			// 开始生产----------
			this.name = name;
			Thread.sleep(10);
			this.gender = gender;
			// 生产结束----------
			isEmpty = false;// 设置共享资源状态不空
			this.notify();// 唤醒一个消费者
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 消费者从共享对象中取出数据
	 */
	synchronized public void popup() {
		try {
			while (isEmpty) {// 共享资源为空，等着生产者生产
				// 使用同步锁对象来调用，表示当前线程释放同步锁，进入等待池，只能被其他线程所唤醒
				this.wait();
			}
			// 消费开始-------
			System.out.println(this.name + "-" + this.gender);
			Thread.sleep(10);
			// 消费结束---------
			isEmpty = true;// 设置共享资源为空
			this.notify();// 唤醒一个生产者
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
