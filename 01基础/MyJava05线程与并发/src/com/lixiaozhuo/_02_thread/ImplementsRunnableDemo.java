package com.lixiaozhuo._02_thread;

//实现Runnable接口
class MusicRunnable implements java.lang.Runnable {

	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println("Music:" + i);
		}
	}

}

public class ImplementsRunnableDemo {

	public static void main(String[] args) {
		Runnable music = new MusicRunnable();
		Thread t = new Thread(music);
		t.start();// 音乐线程
		// 主线程
		for (int i = 0; i < 100; i++) {
			System.out.println("主线程" + i);
		}
	}

}
