package com.lixiaozhuo._05_wildcard;

import com.opensymphony.xwork2.ActionSupport;

//方法调用测试
public class UserAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	
	@Override
	public String execute() throws Exception {
		System.out.println("UserAction.execute()");
		return NONE;
	}
	
	public String save() throws Exception {
		System.out.println("UserAction.save()");
		return NONE;
	}
	
	public String delete() throws Exception {
		System.out.println("UserAction.delete()");
		return NONE;
	}

}
