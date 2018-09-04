package com.lixiaozhuo._01_logon.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//主界面验证
@WebServlet("/main")
public class MainServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Object user =  req.getSession().getAttribute("USER_IN_SESSION");
		//没有登录回到登录界面
		if(user == null){
			req.setAttribute("errorMsg", "请先登录");
			resp.sendRedirect("/logon.jsp");
			return ;
		}
		//显示响应页面
		req.getRequestDispatcher("/WEB-INF/main.jsp").forward(req, resp);
	}
	
}

