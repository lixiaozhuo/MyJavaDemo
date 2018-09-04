package com.lixiaozhuo._01_logon.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lixiaozhuo._01_logon.dao.IUserDAO;
import com.lixiaozhuo._01_logon.dao.impl.UserDAOImpl;
import com.lixiaozhuo._01_logon.domain.User;

//登录处理
@WebServlet("/logon")
public class LogonServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private IUserDAO dao = new UserDAOImpl();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		Object randomCode =  req.getSession().getAttribute("RANDOMCODE_IN_SESSION");
		System.out.println(randomCode);
		System.out.println(req.getParameter("randomCode"));
		//检查验证码
		if(!randomCode.equals(req.getParameter("randomCode"))){
			req.setAttribute("errorMsg", "验证码错误");
			req.getRequestDispatcher("/logon.jsp").forward(req, resp);
			req.getSession().removeAttribute("RANDOMCODE_IN_SESSION");
			return;
		}
		//验证码只使用一回,清除验证码
		req.getSession().removeAttribute("RANDOMCODE_IN_SESSION");
		//=============================================
		//接收请求参数封装成对象
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		//调用业务方法,处理请求
		User user = dao.getUserByUsername(username);
		//控制页面跳转
		//用户不存在或者密码不匹配,调到登录接卖弄,给予提示错误信息
		if(user == null || !password.equals(user.getPassword())){
			req.setAttribute("errorMsg", "用户或密码错误");
			req.getRequestDispatcher("/logon.jsp").forward(req, resp);
			return;
		}
		//登录成功的用户保存在session
		req.getSession().setAttribute("USER_IN_SESSION", user);
		//登录成功,转到响应页面
		resp.sendRedirect("/main");
		
	}
	
}

