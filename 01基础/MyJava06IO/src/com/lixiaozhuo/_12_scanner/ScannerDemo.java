package com.lixiaozhuo._12_scanner;

import java.util.Scanner;

//扫描器
public class ScannerDemo {
	public static void main(String[] args) throws Exception {
		//扫描文件
		//Scanner sc = new Scanner(new File("file/Stream.txt"),"GBK");
		//扫描键盘数据
		//Scanner sc = new Scanner(System.in);
		//扫描字符串中数据
		Scanner sc = new Scanner("abd");
		while(sc.hasNextLine()){
			String line = sc.nextLine();
			System.out.println(line);
		}
		sc.close();
	}
}
