package com.lixiaozhuo._06_api;

import org.apache.struts2.dispatcher.HttpParameters;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import lombok.Setter;

//访问ServletAPI 方式3:通过ActionContext工具类
public class Type3Action extends ActionSupport {

	private static final long serialVersionUID = 1L;
	@Setter
	private String name;
	@Override
	public String execute() throws Exception {
		System.out.println("Type3Action.execute()");
		System.out.println("name : " + name);
		
		 HttpParameters params = ActionContext.getContext().getParameters();
		System.out.println(params.get("name"));
		return NONE;
	}
}
