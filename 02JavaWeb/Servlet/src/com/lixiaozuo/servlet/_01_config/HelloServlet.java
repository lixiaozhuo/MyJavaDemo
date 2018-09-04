package com.lixiaozuo.servlet._01_config;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

//Servelet基本结构配置
public class HelloServlet implements Servlet {
	//构造函数
	public HelloServlet() {
		System.out.println("--------构造函数-----------");
	}

	private ServletConfig config;
	
	//初始化函数
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("-------初始化函数------------");
		this.config = config;
	}
	
	//服务函数
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("-------服务函数------------");
		//Servlet名字
		System.out.println(config.getServletName());
		//获取ServletContext
		System.out.println(config.getServletContext());
		//获取指定参数
		System.out.println(config.getInitParameter("encoding"));
		//获取参数
		for (Enumeration<String> enumeration = config
				.getInitParameterNames(); enumeration.hasMoreElements();) {
			System.out.println(enumeration.nextElement());
		}
	}
	
	//释放函数
	@Override
	public void destroy() {
		System.out.println("------释放资源-------------");
	}

	@Override
	public String getServletInfo() {

		return null;
	}

	@Override
	public ServletConfig getServletConfig() {

		return null;
	}

}
