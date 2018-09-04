package com.lixiaozhuo._01_input;

import java.util.Scanner;

//使用Scanner扫描器
public class ScannerDemo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//读取输入的数据
		String line = sc.nextLine();
		System.out.println("读入的数据:" + line);
		sc.close();
	}

}
