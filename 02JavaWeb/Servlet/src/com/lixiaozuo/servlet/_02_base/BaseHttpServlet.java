package com.lixiaozuo.servlet._02_base;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//继承HttpServlet实现Servlet
@SuppressWarnings("all")
public class BaseHttpServlet extends HttpServlet {
	/**
	 * 两种方式新建HttpServlet
	 * 1.重写service(HttpServletRequest req, HttpServletResponse resp)
	 * 2.重写doPost和doGet 其中一个调用另个一个方法,即在一个方法里处理post和get方式
	 */
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

	// @Override
	// protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	// throws ServletException, IOException {
	//
	// }
	//
	// @Override
	// protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	// throws ServletException, IOException {
	// doPost(req, resp);
	// }

}
