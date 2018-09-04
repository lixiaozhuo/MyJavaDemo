package com.lixiaozuo.servlet._03_request;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//HttpServletRequest常用方法
public class HttpServletRequsetDemo extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("---------------------");
		// 1.String getMethod():返回请求方式：如GET/POST
		System.out.println("请求方式:" + req.getMethod());
		// 2.String getRequestURI():返回请求行中的资源名字部分:如/test/index.html
		System.out.println("请求行中资源部分:" + req.getRequestURI());
		// 3.StringBuffer getRequestURL():返回浏览器地址栏中所有的信息
		System.out.println("浏览器地址栏所有信息:" + req.getRequestURL());
		// 4.String getContextPath():返回当前项目的上下文路径,该值以/开头(<Context/>元素的path属性值.)
		System.out.println("当前项目的上下文路径:" + req.getContextPath());
		// 5.String getRemoteAddr():返回发出请求的客户机的IP地址
		System.out.println("客户机的IP地址:" + req.getRemoteAddr());
		// 6.String getHeader(String name):返回指定名称的请求头的值。
		System.out.println("指定名称的请求头值:" + req.getHeader("User-Agent"));
		System.out.println("---------------------");
		// 获取请求参数的方法:
		// 1.String getParameter(String name):根据参数名获取单个参数值。
		System.out.println("根据参数获取单个参数值:" + req.getParameter("username"));
		// 2.String[] getParameterValues(String name):根据参数名获取多个参数值。
		System.out.println("根据参数获取多个参数值:" + req.getParameterValues("like"));
		// 3.Enumeration<String> getParameterNames():返回包含所有参数名的Enumeration对象。
		System.out.println("包含所有参数名的古老迭代器:" + req.getParameterNames());
		// 4.Map<String,String[]> getParameterMap():返回所有的参数名和值所组成的Map对象。
		System.out.println("所有参数名和值组成Map对象:" + req.getParameterMap());
	}
}
