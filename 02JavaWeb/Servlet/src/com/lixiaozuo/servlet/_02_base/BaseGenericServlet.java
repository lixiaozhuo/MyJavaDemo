package com.lixiaozuo.servlet._02_base;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
@SuppressWarnings("all")

//继承GenericServlet实现Servlet
public class BaseGenericServlet extends GenericServlet {
	
	//重写init函数         不用重写init(ServletConfig config)方法 ---模板设计模式
	@Override
	public void init(){
		
	}
	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("-------服务函数------------");
		//实现了ServletConfig直接调用即可  此为GenericServlet的方法
		System.out.println(getServletName());
		System.out.println(getServletContext());
	}

}
