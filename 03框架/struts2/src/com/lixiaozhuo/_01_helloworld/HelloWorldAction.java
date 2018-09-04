package com.lixiaozhuo._01_helloworld;


//第一个Action
public class HelloWorldAction {
	public String execute(){
		System.out.println("HelloWorldAction1==>execute");
		return "index";//逻辑视图
	}
}
