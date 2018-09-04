package com.lixiaozhuo._04_synchronized;

//单例模式-饿汉式 
public class OneInstance1 {
	private OneInstance1(){}
	private static OneInstance1 instance = new OneInstance1();
	public static OneInstance1 getInstance(){
		return instance;
	}
}
