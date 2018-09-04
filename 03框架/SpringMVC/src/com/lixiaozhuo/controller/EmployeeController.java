package com.lixiaozhuo.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.lixiaozhuo.domain.User;

@Controller // 表示该类使用注解来配置URL信息
// @RequestMapping("/employee")
public class EmployeeController {

	@RequestMapping("/employee_save") // 配置请求的url路径
	public ModelAndView save(HttpServletResponse arg1) throws Exception {
		System.out.println("EmployeeController.save()");
		return null;
	}

	/**
	 * 传参数的方式
	 */
	// 基于请求参数与形参同名的原则
	@RequestMapping("/login1")
	public void login1(HttpServletResponse arg1, String username,
			String password) {
		System.out.println("username : " + username);
		System.out.println("password : " + password);
	}

	// 请求参数名称和形参的名称不同时,可以使用@RequestParam来设置参数注入
	@RequestMapping("/login2")
	public void login2(HttpServletResponse arg1,
			@RequestParam("username") String name, String password) {
		System.out.println("name : " + name);
		System.out.println("password : " + password);
	}

	// 数据模型传值
	@RequestMapping("/login3")
	public void login3(HttpServletResponse arg1, User user) {
		System.out.println("username : " + user.getUsername());
		System.out.println("password : " + user.getPassword());
	}

	// 地址栏传参:通过url请求路径来设置参数(了解)
	@RequestMapping("/login4/{uid}")
	public void login4(HttpServletResponse arg1, @PathVariable("uid") Long id) {
		System.out.println(id);
	}

	/**
	 * 传值方式
	 */
	// 返回类型不是string类型把当前请求的url路径当作视图名称,并且加上视图解析器的前缀和后缀
	@RequestMapping("/index1")
	public User index1() {
		User user = new User();
		user.setUsername("aaa");
		user.setPassword("bbb");
		return user;
	}

	// 如果返回类型是String类型,那么直接当作视图名称,并且加上视图解析器的前缀和后缀
	@RequestMapping("/index2")
	public String index2(Model model) {
		User user = new User();
		user.setUsername("aaa");
		user.setPassword("bbb");
		model.addAttribute(user);
		return "index1";
	}
	
	@RequestMapping("/index3")
	public String index3(Model model) {
		User user = new User();
		user.setUsername("aaa");
		user.setPassword("bbb");
		model.addAttribute(user);
		//return "forward:/WEB-INF/index.jsp";//请求转发
		return "redirect:index.html";//重定向
	}
}
