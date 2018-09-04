package com.lixiaozhuo._06_api;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

//访问ServletAPI 方式2:通过ServletActionContext工具类
public class Type2Action extends ActionSupport {

	private static final long serialVersionUID = 1L;

	@Override
	public String execute() throws Exception {
		System.out.println("Type2Action.execute()");
		System.out
				.println(ServletActionContext.getRequest().getParameter("name"));
		return NONE;
	}
}
