package com.lixiaozhuo._02_thread;

//继承Thead方式
class MusicThread extends java.lang.Thread {
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("Music" + i);
		}
	}
}

public class ExtendsThreadDemo extends Thread {
	public static void main(String[] args) {
		MusicThread music = new MusicThread();
		ExtendsThreadDemo games = new ExtendsThreadDemo();
		music.start();//音乐线程开启
		games.start();//游戏线程开启
	}

	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("games:" + i);
		}
	}
}
