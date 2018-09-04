package com.lixiaozhuo.web.action;

import com.lixiaozhuo.domain.Employee;
import com.lixiaozhuo.service.IEmployeeService;
import com.lixiaozhuo.service.impl.EmployeeServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import lombok.Setter;

public class LoginAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private IEmployeeService service = new EmployeeServiceImpl();
	
	@Setter
	private String username;
	
	@Setter
	private String password;
	
	public String execute() throws Exception {
		Employee employee = service.checkLogin(username,password);
		System.out.println(employee);
		if(employee == null){
			addActionError("用户名或密码错误");
			return LOGIN;
		}
		ActionContext.getContext().getSession().put("USER_IN_SESSION", employee);
		return SUCCESS;
	}

}
