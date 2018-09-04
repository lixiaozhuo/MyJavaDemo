package com.liixiaozhuo.jQuery._01_check_username;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;
import com.liixiaozhuo.jQuery.JSONObject;
import com.opensymphony.xwork2.ActionSupport;

import lombok.Setter;

//检查用户名是否存在
public class CheckUsername extends ActionSupport {

	private static final long serialVersionUID = 1L;

	@Setter
	private String username;
	// 模拟用户名称
	private List<String> listData = Arrays.asList("admin", "root");

	@Override
	public String execute() throws Exception {
		JSONObject jsonObject = new JSONObject();

		if (listData.contains(username)) {
			jsonObject.setSuccess(false);
			jsonObject.setData("该用户已注册");
		} else {
			jsonObject.setSuccess(true);
			jsonObject.setData("用户名可用");
		}
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/json;charset=utf-8");
		response.getWriter().println(JSON.toJSONString(jsonObject));
		return NONE;
	}
}
