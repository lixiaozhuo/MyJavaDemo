package com.lixiaozhuo.web.logon.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//注销处理
@WebServlet("/logout")
public class LogoutSerlvet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {		
		//销毁session对象
		req.getSession().invalidate();
		//转到登录界面
		resp.sendRedirect("/logon.jsp");
	}
	
}

