package com.lixiaozhuo.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lixiaozhuo.domain.JsonResult;

//JSON数据类型处理
@Controller
public class JSONController {
	@RequestMapping("/json")
	@ResponseBody // 将返回的对象解析成JSON格式返回给客户端.s
	public JsonResult index1() {
		JsonResult result = new JsonResult();
		result.setSuccess(true);
		result.setMsg("bbb");
		result.setDate(new Date());
		return result;
	}

	// 接收data数据
	@RequestMapping("/json_data")
	public void index2(JsonResult m) {
		System.out.println(m);
	}
	
	//在Controller上添加initBinder方法 处理日期格式
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		System.out.println("JSONController.initBinder()");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.setLenient(false);
		binder.registerCustomEditor(Date.class,
				new CustomDateEditor(sdf, true));
	}
}
