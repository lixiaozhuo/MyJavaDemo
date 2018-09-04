package com.lixiaozhuo._04_scope;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//作用域测试
@WebServlet("/scope")
public class ScopeServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 接收参数,并包装成对象
		// request 获取参数不存在则创建参数,存在则加1
		Integer numReq = (Integer) req.getAttribute("NUM_IN_REQ");
		if (numReq == null) {
			req.setAttribute("NUM_IN_REQ", 1);
		} else {
			req.setAttribute("NUM_IN_REQ", numReq + 1);
		}
		// session 获取参数不存在则创建参数,存在则加1
		HttpSession session = req.getSession();
		Integer numSession = (Integer) session.getAttribute("NUM_IN_SESSION");
		if (numSession == null) {
			session.setAttribute("NUM_IN_SESSION", 1);
		} else {
			session.setAttribute("NUM_IN_SESSION", numSession + 1);
		}

		// ServletContext/Application  获取参数不存在则创建参数,存在则加1
		ServletContext context = req.getServletContext();
		Integer numApp = (Integer) context.getAttribute("NUM_IN_APP");
		if (numApp == null) {
			context.setAttribute("NUM_IN_APP", 1);
		} else {
			context.setAttribute("NUM_IN_APP", numApp + 1);
		}

		// 调用业务方法处理请求

		// 控制页面跳转
		req.getRequestDispatcher("result").forward(req, resp);
	}
}
