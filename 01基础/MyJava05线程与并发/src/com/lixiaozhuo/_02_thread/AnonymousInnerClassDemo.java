package com.lixiaozhuo._02_thread;

//匿名内部类运行线程
public class AnonymousInnerClassDemo {
	public static void main(String[] args) {
		test2();
	}
	//实现Runnable接口
	public static void test1(){
		new Thread(new Runnable(){
			public void run(){
				for(int i = 0;i < 100;i++){
					System.out.println("Runable线程:"+i);
				}
			}
		}).start();
		for(int i = 0;i < 100;i++){
			System.out.println("test1主线程"+i);
		}
	}
	//继承threadf方式
	public static void test2(){
		new Thread(){
			public void run(){
				for(int i = 0;i < 100;i++){
					System.out.println("Thread线程:"+i);
				}
			}
		}.start();
		for(int i = 0;i < 100;i++){
			System.out.println("test2主线程"+i);
		}
	}
}
