package com.lixiaozhuo._01_mapping;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//注解&映射测试

//urlPatterns/value:资源映射
//initParams:初始化参数
//loadOnStartup:资源加载时间
@WebServlet(urlPatterns = "/calc", initParams = {
		@WebInitParam(name = "aaa", value = "bbb") }, loadOnStartup = -1)
public class MappingServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public MappingServlet() {
		System.out.println("创建");
	}

	@Override
	public void init() throws ServletException {
		System.out.println("初始化");
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 设置请求体的解码方式:适用Post方式
		req.setCharacterEncoding("utf-8");
		// 同时设置响应的MIME类型和打开响应体的字符集
		resp.setContentType("text/html;charset=utf-8");
		// 获取属性
		String snum1 = req.getParameter("num1");
		String snum2 = req.getParameter("num2");
		String operation = req.getParameter("operation");
		Object res = 0;
		if (snum1 == null) {
			snum1 = new String("0");
		}
		if (snum2 == null) {
			snum2 = new String("0");
		}
		if (operation == null) {
			operation = new String("+");
		}
		// 计算值
		Integer num1 = Integer.valueOf(snum1);
		Integer num2 = Integer.valueOf(snum2);
		switch (operation) {
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
		// 显示页面
		PrintWriter writer = resp.getWriter();
		writer.println("<!DOCTYPE html>");
		writer.println("<html>");
		writer.println("<head>");
		writer.println("<meta charset=\"UTF-8\">");
		writer.println("<title>Insert title here</title>");
		writer.println("</head>");
		writer.println("<body>");
		writer.println(
				"<form action=\"" + req.getRequestURI()
						+ "\" method=\"post\">");
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
