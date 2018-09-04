package com.lixiaozuo.servlet._06_calc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//简易计算器
public class MyCalc extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		req.setCharacterEncoding("utf-8");
		//获取属性
		String snum1 = req.getParameter("num1");
		String snum2 = req.getParameter("num2");
		String operation = req.getParameter("operation");
		Object res = 0;
		if(snum1 == null){
			snum1 = new String("0");
		}
		if(snum2 == null){
			snum2 = new String("0");
		}
		if(operation == null){
			operation = new String("+");
		}
		//计算值
		Integer num1 = Integer.valueOf(snum1);
		Integer num2 = Integer.valueOf(snum2);
		switch(operation){
		case "+":
			res = num1 + num2;
			break;
		case "-":
			res = num1 - num2;
			break;
		case "*":
			res = num1 * num2;
			break;
		case "/":
			res = num1 / num2;
			break;
		}
		//显示页面
		PrintWriter writer = resp.getWriter();
		writer.println("<!DOCTYPE html>");
		writer.println("<html>");
		writer.println("<head>");
		writer.println("<meta charset=\"UTF-8\">");
		writer.println("<title>Insert title here</title>");
		writer.println("</head>");
		writer.println("<body>");
		writer.println(
				"<form action=\"" + req.getContextPath()
						+ "/calc\" method=\"post\">");
		writer.println(
				"<input type=\"number\" name=\"num1\" value=\"" + snum1
						+ "\" />");
		writer.println("<select name=\"operation\">");
		writer.println("<option value=\"+\">+</option>");
		writer.println("<option value=\"-\">-</option>");
		writer.println("<option value=\"*\">*</option>");
		writer.println("<option value=\"/\">/</option>");
		writer.println("</select>");
		writer.println(
				"<input type=\"number\" name=\"num2\" value=\"" + snum2
						+ "\" />");
		writer.println("<input type=\"submit\" value=\" = \"/>");
		writer.println(
				"<input type=\"text\" value=\"" + res
						+ "\" readonly=\"readonly\"/>");
		writer.println("</form>");
		writer.println("</body>");
		writer.println("</html>");
		writer.close();
	}

}
