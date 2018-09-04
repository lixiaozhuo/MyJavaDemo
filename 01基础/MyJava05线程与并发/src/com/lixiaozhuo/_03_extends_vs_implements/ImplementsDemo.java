package com.lixiaozhuo._03_extends_vs_implements;

//苹果线程
class Apple implements Runnable{
	private int num = 50;//苹果总数
	public void run() {
		for(int i = 0 ;i < 50;i++){
			if(num > 0){
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName()+"吃了编号为" + num-- + "的苹果");
			}
		}
	}	
}

//使用实现Runnable方式来实现,三个同学吃50个苹果
public class ImplementsDemo {
		public static void main(String[] args) {
		//创建三个线程,吃苹果
		Apple a = new Apple();
		new Thread(a, "A").start();
		new Thread(a, "B").start();
		new Thread(a, "C").start();
		}
}
