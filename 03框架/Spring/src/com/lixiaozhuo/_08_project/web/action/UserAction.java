package com.lixiaozhuo._08_project.web.action;

import com.lixiaozhuo._08_project.domain.User;
import com.lixiaozhuo._08_project.service.IUserService;

import lombok.Setter;

public class UserAction {
	@Setter
	private IUserService userService;
	public String save(User u){
		System.out.println("Action调用Service的方法");
		userService.save(u);
		return "success";
	}
}
