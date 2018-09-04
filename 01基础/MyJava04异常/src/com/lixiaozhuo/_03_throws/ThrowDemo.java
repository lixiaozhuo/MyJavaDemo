package com.lixiaozhuo._03_throws;

//throw语句
public class ThrowDemo {
	public static void main(String[] args) {
		System.out.println(divide(10,0));
	}
	private static int divide(int num1,int num2){
		System.out.println("start-------");
		if(num2 == 0){
			throw new ArithmeticException("除数为0");
		}
		int ret = num1 / num2;
		System.out.println("结果: " + ret);
		System.out.println("end---------");
		return ret;
	}
}
