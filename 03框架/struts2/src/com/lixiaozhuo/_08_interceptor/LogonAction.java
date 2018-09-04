package com.lixiaozhuo._08_interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import lombok.Setter;

public class LogonAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	@Setter
	private String username;
	@Setter
	private String password;
	
	@Override
	public String execute() throws Exception {
		System.out.println("username = " + username);
		System.out.println("password = " + password);
		ActionContext.getContext().getSession().put("USER_IN_SESSION", username);
		if("root".equals(username) && "root" .equals(password)){
			return SUCCESS;			
		}	
		return INPUT;
	}

}
