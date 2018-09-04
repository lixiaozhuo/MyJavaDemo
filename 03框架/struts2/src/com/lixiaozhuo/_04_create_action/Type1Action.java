package com.lixiaozhuo._04_create_action;

//方式1:实现无参的方法
public class Type1Action {
	public String execute(){
		System.out.println("Type1.execute()");		
		return "success";
	}
}
