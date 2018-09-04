package com.lixiaozuo.servlet._05_response;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//HttpServletResponse使用
public class HttpServletResponseDemo extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// //设置响应的MIME类型(告诉浏览器如何正确打开响应的内容)
		// resp.setCharacterEncoding("UTF-8");
		// //设置打开响应体的字符集
		// resp.setContentType("text/html");

		// 同时设置响应的MIME类型和打开响应体的字符集
		resp.setContentType("text/html;charset=utf-8");
		// 获取浏览器管理的字符流
		PrintWriter writer = resp.getWriter();
		writer.print(new Date());
		writer.print("<br/>");

	}

}
