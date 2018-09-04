package com.lixiaozhuo.logon.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//登录处理servlet
@WebServlet("/logon")
public class LongonServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		System.out.println("username = " + username);
		System.out.println("password = " + password);
		req.getSession().setAttribute("USER_IN_SESSION", username);//设置session
		resp.sendRedirect("/system/main.jsp");//重定向主界面
	}
	
}
