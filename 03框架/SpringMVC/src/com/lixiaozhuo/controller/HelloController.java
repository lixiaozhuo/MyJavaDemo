package com.lixiaozhuo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class HelloController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		//使用ModelAndView整合视图
		ModelAndView view = new ModelAndView();
		//设置属性
		view.addObject("msg", "提示信息");
		view.addObject("hello");//默认key是传入对象所属类型的小写字符串
		view.addObject("aaa");//覆盖key
		//设置响应视图
		view.setViewName("/WEB-INF/index.jsp");
		return view;
	}

}
