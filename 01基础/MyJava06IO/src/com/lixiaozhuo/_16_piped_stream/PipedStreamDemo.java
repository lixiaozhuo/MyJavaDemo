package com.lixiaozhuo._16_piped_stream;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

class AThread extends Thread {
	private PipedOutputStream out = new PipedOutputStream();

	public PipedOutputStream getOut() {
		return out;
	}
	public void run() {

		try {
			for (int i = 65; i < 65 + 26; i++) {
				out.write(i);
			}
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

class BThread extends Thread{
	private PipedInputStream in = null;
	
	public BThread(AThread aThread) throws Exception{
		in = new PipedInputStream(aThread.getOut());
	}
	
	public void run(){
		int len = -1;
		try {
			while((len = in.read()) != -1){
				System.out.println((char)len);
			}
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}

//管道流:实现两个线程之间的数据交互.
public class PipedStreamDemo {
	@SuppressWarnings("static-access")
	public static void main(String[] args) throws Exception {
		AThread a = new AThread();
		BThread b = new BThread(a);
		//
		b.start();
		Thread.currentThread().sleep(10000);
		a.start();
	}
}
