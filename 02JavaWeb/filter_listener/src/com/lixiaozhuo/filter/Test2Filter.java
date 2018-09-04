package com.lixiaozhuo.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

//过滤器2
public class Test2Filter implements Filter {
	
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("doFilter2====>begin");
		chain.doFilter(request, response);//放行请求
		System.out.println("doFilter2====>end");
	}

	@Override
	public void destroy() {
	}

}
