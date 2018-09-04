package com.lixiaozhuo._05_application;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Application使用方法
@WebServlet("/application")
public class ApplicationServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		//获取Application对象
		ServletContext context = getServletContext();//继承自ServletConfig类
		req.getServletContext();
		req.getSession().getServletContext();
		//常用方法
		PrintWriter writer = resp.getWriter();
		writer.println("ServletContext名字: " + context.getServletContextName() + "<br/>");
		writer.println("项目的上下文路径: " + context.getContextPath() + "<br/>");
		writer.println("获取当前项目中某资源的绝对路径 : " + context.getRealPath("/application") + "<br/>");
		writer.println("获取web配置的初始化参数: " + context.getInitParameter("name") + "<br/>");		
	}
}