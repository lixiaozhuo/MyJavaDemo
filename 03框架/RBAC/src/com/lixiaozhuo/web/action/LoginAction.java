package com.lixiaozhuo.web.action;

import com.lixiaozhuo.service.IEmployeeService;

import lombok.Setter;

//登录Action
public class LoginAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	@Setter
	private IEmployeeService employeeService;

	@Setter
	private String username;

	@Setter
	private String password;

	@Override
	public String execute() throws Exception {
		try {
			//检查登录
			employeeService.checkLogin(username, password);
		} catch (Exception e) {
			//登录出错,返回登录界面
			super.addActionError(e.getMessage());
			return LOGIN;
		}
		//登录成功
		return SUCCESS;
	}
}
