package com.lixiaozhuo.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lixiaozhuo.domain.Employee;
import com.lixiaozhuo.service.IEmployeeService;
import com.lixiaozhuo.utils.UserContext;

@Controller
public class LoginController extends BaseController {

	@Autowired
	private IEmployeeService employeeService;

	@RequestMapping("/login")
	public String login(String username, String password, HttpSession session) {
		// 检查登录
		Employee employee = employeeService.checkLogin(username, password);
		if (employee == null) {
			return "redirect:login.jsp";
		}
		session.setAttribute(UserContext.USERINSESSION, employee);
		session.setAttribute(UserContext.PERMISSIONINSESSION,
				employeeService.getPermission(employee));
		return "main";
	}
}
