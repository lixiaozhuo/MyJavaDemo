package com.lixiaozhuo._06_api;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

//访问ServletAPI 方式1: 实现感知接口
public class Type1Action extends ActionSupport implements ServletRequestAware{

	private static final long serialVersionUID = 1L;
	
	private HttpServletRequest req;
	
	@Override
	public String execute() throws Exception {
		System.out.println("Type1Action.execute()");
		System.out.println(req.getParameter("name"));
		return NONE;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		req = request;
	}
}
