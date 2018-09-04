package com.lixiaozhuo._06_producer_consumer_lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//共享资源对象（姓名-性别）
public class ShareResource {
	private String name;
	private String gender;
	private boolean isEmpty = true;//表示共享资源对象是否为空
	
	
	private final Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();

	/**
	 * 生产者向共享资源对象存储数据
	 * @param name		存储的姓名
	 * @param gender	存储的性别
	 */
	public void push(String name, String gender) {
		lock.lock();
		try {
			while(!isEmpty){//共享资源不空，等待消费者消费
				condition.await();
			}
			//开始生产----------
			this.name = name;
			Thread.sleep(10);
			this.gender = gender;
			//生产结束----------
			isEmpty = false;
			condition.signalAll();//唤醒消费者
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();//释放锁
		}
	}

	/**
	 * 消费者从共享对象中取出数据
	 */
	public void popup() {
		lock.lock();
		try {
			while(isEmpty){//共享资源为空，等待生产者生产
				
				condition.await();
			}
			//消费开始-------
			System.out.println(this.name + "-" + this.gender);
			Thread.sleep(10);
			//消费结束---------
			isEmpty = true;//共享资源为空
			condition.signal();//唤醒生产者
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();//释放锁
		}

	}
}
