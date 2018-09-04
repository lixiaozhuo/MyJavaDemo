package com.lixiaozhuo._03_include;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//页面重定向方式交互
@WebServlet("/include/a")
public class Include1Servlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		//1.接收请求参数并封装成对象
		//2.调用业务方法处理请求		
		PrintWriter writer = resp.getWriter();
		writer.print("------servlet1_before------");
		System.out.println("------servlet1_before------");
		//3.控制页面跳转
		//=====================
		req.getRequestDispatcher("/include/b").include(req, resp);
		//=====================
		writer.println("------servlet1_after------");
		System.out.println("------servlet1_after------");
		
	}
}
