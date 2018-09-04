package com.lixiaozhuo._04_create_action;

import com.opensymphony.xwork2.Action;

//方式2:实现Action接口,覆写execute方法
public class Type2Action implements Action{

	@Override
	public String execute() throws Exception {
		System.out.println("Type2.execute()");
		return SUCCESS;
	}
	
}
