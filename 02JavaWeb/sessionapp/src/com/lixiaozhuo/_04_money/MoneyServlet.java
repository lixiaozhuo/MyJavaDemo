package com.lixiaozhuo._04_money;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/money")
public class MoneyServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		Object tokenInSession = req.getSession().getAttribute("TOKEN_IN_SESSION");
		String tokenInParm = req.getParameter("token");
		if(!tokenInParm.equals(tokenInSession)){
			System.out.println("错误");
			//清除session中的token
			req.getSession().removeAttribute("TOKEN_IN_SESSION");
			return;
		}		
		String money = req.getParameter("money");
		System.out.println(money);
		
		//清除session中的token
		req.getSession().removeAttribute("TOKEN_IN_SESSION");
	}
	
}

