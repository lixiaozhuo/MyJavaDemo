package com.lixiaozhuo._04_synchronized;

class Apple2 implements Runnable {
	private int num = 50;//苹果总数

	 public void run() {
		for (int i = 0; i < 50; i++) {
			eat();
		}
	}
	 synchronized private void eat(){
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

//同步方法
public class SynchronizedMethodDemo {
	public static void main(String[] args) {
		Apple2 a = new Apple2();
		new Thread(a, "A").start();
		new Thread(a, "B").start();
		new Thread(a, "C").start();
	}
}
