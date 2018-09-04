package com.lixiaozhuo._12_project_annon.web.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.lixiaozhuo._12_project_annon.domain.User;
import com.lixiaozhuo._12_project_annon.service.IUserService;

@Controller//标注控制层组件
@Scope("prototype")//指定bean作用域
public class UserAction {
	@Autowired
	private IUserService userService;

	public String save(User u) {
		System.out.println("Action调用Service的方法");
		userService.save(u);
		return "success";
	}
}
