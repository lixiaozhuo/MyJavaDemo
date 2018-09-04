package com.lixiaozhuo._10_validation;

import org.apache.commons.lang3.StringUtils;

import com.opensymphony.xwork2.ActionSupport;

import lombok.Setter;


//输入校验
public class ValidationAction extends ActionSupport {


	private static final long serialVersionUID = 1L;
	
	@Setter
	private String username;
	
	@Setter
	private String password;
	
	//编写校验规则
	public void validateExecute() {
		if (StringUtils.isBlank(username) || username.length() < 4) {
			addActionError("用户名不可小于4位");
		}
		if(StringUtils.isBlank(password) || password.length() < 4){
			addActionError("密码不可小于4位");
		}
	}
	
	@Override
	public String execute() throws Exception {
		System.out.println("ValidationAction.execute()");
		return NONE;
	}
	
	public String save(){
		System.out.println("ValidationAction.save");
		return NONE;
	}
	
	public String delete(){
		System.out.println("ValidationAction.delete");
		return NONE;
	}
	
		
}
