package com.lixiaozhuo._04_synchronized;

class Apple1 implements Runnable {
	private int num = 50;//苹果总数

	public void run() {
		for (int i = 0; i < 50; i++) {
			//同步代码块
			synchronized (this) {//this表示Apple对象，该对象属于多线程共享
				if (num > 0) {
					System.out.println(Thread.currentThread().getName() + "吃了编号" + num + "苹果");
					//模拟网络延迟
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					num--;
				}
			}
		}
	}
}

//同步代码块
public class SynchronizedBlockDemo {
	public static void main(String[] args) {
		Apple1 a = new Apple1();
		new Thread(a, "A").start();
		new Thread(a, "B").start();
		new Thread(a, "C").start();
	}
}

