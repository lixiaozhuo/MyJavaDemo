package com.lixiaozhuo._04_synchronized;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Apple3 implements Runnable {
	private int num = 50;// 苹果总数
	private final Lock lock = new ReentrantLock();

	public void run() {
		for (int i = 0; i < 50; i++) {
			eat();
		}
	}

	private void eat() {
		// 进入方法立马加锁
		lock.lock();

		try {
			if (num > 0) {
				System.out.println(Thread.currentThread().getName() + "吃了编号" + num + "苹果");
				// 模拟网络延迟
				Thread.sleep(10);
			}
			num--;
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			// 释放锁
			lock.unlock();
		}

	}
}

// 同步锁(Lock)
public class LockDemo {
	public static void main(String[] args) {
		Apple3 a = new Apple3();
		new Thread(a, "A").start();
		new Thread(a, "B").start();
		new Thread(a, "C").start();
	}
}
