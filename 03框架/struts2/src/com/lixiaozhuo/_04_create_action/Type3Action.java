package com.lixiaozhuo._04_create_action;

import com.opensymphony.xwork2.ActionSupport;

//方式3:继承ActionSupport类,覆写execute方法
public class Type3Action extends ActionSupport {

	private static final long serialVersionUID = 1L;

	@Override
	public String execute() throws Exception {
		System.out.println("type3.execute()");

		return SUCCESS;
	}
}
