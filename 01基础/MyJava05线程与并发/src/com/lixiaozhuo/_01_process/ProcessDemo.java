package com.lixiaozhuo._01_process;

import java.io.IOException;

//java中开启一个进程
public class ProcessDemo {
	public static void main(String[] args) throws IOException {
		//使用runtime类的exec方法
		Runtime runTime = Runtime.getRuntime();
		runTime.exec("notepad");
		//ProcessBuilder的Start方法
		ProcessBuilder pb = new ProcessBuilder("notepad");
		pb.start();
	}
}
