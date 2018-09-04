package com.lixiaozhuo._02_session.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//session方式:列表处理界面
@WebServlet("/session/list")
public class List extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 设置请求体的解码方式:适用Post方式
		req.setCharacterEncoding("utf-8");
		// 同时设置响应的MIME类型和打开响应体的字符集
		resp.setContentType("text/html;charset=utf-8");
		// 接收请求参数
		String username = "";
		HttpSession session = req.getSession();
		username = ((User) session.getAttribute("USE_IN_SESSION")).getName();
		// session.removeAttribute("USE_IN_SESSION"); //删除指定属性
		// session.invalidate();//销毁对象
		// session.setMaxInactiveInterval(60*30);//超时管理
		// 调用业务方法处理需求
		// 控制界面跳转
		PrintWriter writer = resp.getWriter();

		writer.print("<!DOCTYPE html>");
		writer.print("<html>");
		writer.print("<head>");
		writer.print("<meta charset=\"UTF-8\">");
		writer.print("<title></title>");
		writer.print("</head>");
		writer.print("<body>");

		writer.print("<h3>欢迎!" + username + "</h3>");
		for (int i = 0; i < 3; i++) {
			writer.print("<a href=\"/session/session/get\">邮件</a><br/>");
		}

		writer.print("</body>");
		writer.print("</html>");
	}
}