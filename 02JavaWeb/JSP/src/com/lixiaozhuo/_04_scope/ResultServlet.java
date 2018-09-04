package com.lixiaozhuo._04_scope;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//作用域测试
@WebServlet("/result")
public class ResultServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		//request
		Integer numReq =(Integer) req.getAttribute("NUM_IN_REQ");		
		//session
		Integer numSession = (Integer)req.getSession().getAttribute("NUM_IN_SESSION");		
		//ServletContext/Application
		Integer numApp = (Integer) req.getServletContext().getAttribute("NUM_IN_APP");
		
		PrintWriter writer = resp.getWriter();
		writer.println("request => " + numReq + "<br/>");
		writer.println("session => " + numSession + "<br/>");
		writer.println("Application =>" + numApp + "<br/>");
	}
}
