package com.liixiaozhuo.ajax._02_check_username;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

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
		String msg;
		if (listData.contains(username)) {
			msg = "该用户已注册";
		} else {
			msg = "用户名可用";
		}
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().println(msg);
		return NONE;
	}
}
