package com.lixiaozhuo._07_thread_method;

class Join extends Thread {
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println("join=" + i);
		}
	}
}

//联合线程
public class JoinDemo {
	public static void main(String[] args) throws Exception {
		System.out.println("begin------");
		Join join = new Join();
		for (int i = 0; i < 100; i++) {
			System.out.println("main=" + i);
			if (i == 1) {
				//启动join线程
				join.start();
			}
			if(i==20){
				join.join();//强制运行该线程
			}
		}
		System.out.println("end------");

	}
}
