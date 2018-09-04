package com.liixiaozhuo.jQuery._02_login;

import com.opensymphony.xwork2.ActionSupport;

import lombok.Setter;

//用户登录
public class Login extends ActionSupport {

	private static final long serialVersionUID = 1L;

	@Setter
	private String username;
	
	@Setter
	private String password;

	@Override
	public String execute() throws Exception {
		System.out.println("username = " + username + ",password = " + password);
		return NONE;
	}
}
