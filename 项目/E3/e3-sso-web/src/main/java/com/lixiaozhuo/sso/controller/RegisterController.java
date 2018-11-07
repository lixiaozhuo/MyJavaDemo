package com.lixiaozhuo.sso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lixiaozhuo.pojo.E3Result;
import com.lixiaozhuo.pojo.TbUser;
import com.lixiaozhuo.sso.service.RegisterService;

/**
 * 注册功能Controller
 * 
 * @author lxz
 *
 */
@Controller
public class RegisterController {
	/**
	 * 注册服务
	 */
	@Autowired
	private RegisterService registerService;
	
	@RequestMapping("/page/register")
	public String showRegisterIndex() {
		// 注册页面
		return "register";
	}
	
	@RequestMapping("/user/check/{param}/{type}")
	@ResponseBody
	public E3Result checkData(@PathVariable String param,@PathVariable Integer type){
		//检查登录数据
		E3Result result = registerService.checkData(param, type);
		return result;
	}
	
	@RequestMapping(value="/user/register",method=RequestMethod.POST)
	@ResponseBody
	public E3Result register(TbUser user){
		//注册
		E3Result result = registerService.register(user);
		return result;
	}
	
	
}
