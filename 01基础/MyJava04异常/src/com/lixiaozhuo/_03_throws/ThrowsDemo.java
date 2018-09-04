package com.lixiaozhuo._03_throws;

//throws语句
public class ThrowsDemo {
	public static void main(String[] args) throws Exception {
			test(10,2);

	}
	private static int test(int num1,int num2) throws Exception{
		System.out.println("start-------");
		if(num2 == 0){
			//throw new RuntimeException("除数为0");
			throw new Exception("除数为0");
		}
		int ret = num1 / num2;
		System.out.println("结果" + ret);
		System.out.println("end---------");
		return ret;
	}
}
