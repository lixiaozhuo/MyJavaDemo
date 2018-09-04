package com.lixiaozuo.servlet._04_regist;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//注册界面响应
public class RegisteHttpServletRequest extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//修改请求体的解码方式
		req.setCharacterEncoding("UTF-8");
		// 获取请求参数,封装成对象
		String username = req.getParameter("username");
		// 出现乱码,先解码在编码
		// byte[] bs = username.getBytes("ISO-8859-1");
		// username = new String(bs,"UTF-8");

		String password = req.getParameter("password");
		String gender = req.getParameter("gender");
		String city = req.getParameter("city");
		String info = req.getParameter("info");
		User user = new User(username, password, gender, city, info);
		System.out.println(user);

		String[] hobby = req.getParameterValues("hobby");
		System.out.println(Arrays.toString(hobby));
		// 调用业务方法处理需求
		// 控制界面跳转
	}
}
