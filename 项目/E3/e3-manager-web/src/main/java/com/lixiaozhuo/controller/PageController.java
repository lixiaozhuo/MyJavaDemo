package com.lixiaozhuo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 界面展示控制器
 * @author lxz
 *
 */
@Controller
public class PageController {
	
	@RequestMapping("/")
	public String showIndex(){
		//首页
		return "index";
	}
	
	@RequestMapping("/{page}")
	public String showPage(@PathVariable String page){
		//根据参数显示不同jsp页面
		return page;
	}
}
