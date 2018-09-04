package com.lixiaozhuo._01_catch;

//单个异常捕捉
public class SingleCatchDemo {
	public static void main(String[] args) {
		System.out.println("begin");
		try{
			int ret = 10 / 0;
			System.out.println(ret);
		}catch(Exception e){
			System.out.println("异常信息:" + e.getMessage());
			e.printStackTrace();
		}		
		System.out.println("end");
	}
}
