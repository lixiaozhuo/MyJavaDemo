package com.lixiaozhuo.sso.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.lixiaozhuo.pojo.E3Result;
import com.lixiaozhuo.sso.service.LoginService;
import com.lixiaozhuo.utils.CookieUtils;

/**
 * 登录功能Controller
 * 
 * @author lxz
 *
 */
@Controller
public class LoginController {

	/**
	 * 登录Service
	 */
	@Autowired
	private LoginService loginService;

	/**
	 * cookie中token的key
	 */
	@Value("${TOKEN_KEY}")
	private String TOKEN_KEY;

	@RequestMapping("/page/login")
	public String showLoginIndex(String redirect, Model model) {
		// 转码
		try {
			redirect = new String(redirect.getBytes("ISO-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		// 将需要跳转url传递给页面
		model.addAttribute("redirect", redirect);
		// 登录页面
		return "login";
	}

	@RequestMapping(value = "/user/login", method = RequestMethod.POST)
	@ResponseBody
	public E3Result login(String username, String password,
			HttpServletRequest request, HttpServletResponse response) {
		// 登录
		E3Result result = loginService.login(username, password);
		// 登录失败
		if (result.getStatus() != 200) {
			return result;
		}
		// 登录成功将token加入cookie
		String token = result.getData().toString();
		CookieUtils.setCookie(request, response, TOKEN_KEY, token);
		return result;
	}

	@RequestMapping(value = "/user/logout")
	public String logout(String redirect, HttpServletRequest request,
			HttpServletResponse response,RedirectAttributes redirectAttributes) {
		if (redirect == null) {
			redirect = "http://localhost:82";
		}
		// 删除cookie中token
		CookieUtils.deleteCookie(request, response, TOKEN_KEY);
			
		// 跳转到登录界面
		return "redirect:http://localhost:85/page/login?redirect=" + redirect;
	}
}
