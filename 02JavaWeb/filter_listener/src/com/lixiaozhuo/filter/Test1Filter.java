package com.lixiaozhuo.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

//过滤器1
public class Test1Filter implements Filter {
	public Test1Filter(){
		System.out.println("过滤器对象创建");
	}
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("过滤器对象初始化");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("doFilter1====>begin");
		chain.doFilter(request, response);//放行请求
		System.out.println("doFilter1====>end");
	}

	@Override
	public void destroy() {
	}

}
