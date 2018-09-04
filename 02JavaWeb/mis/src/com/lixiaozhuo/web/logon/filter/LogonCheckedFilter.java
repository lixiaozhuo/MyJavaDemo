package com.lixiaozhuo.web.logon.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//登录检查过滤器
public class LogonCheckedFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		Object user = req.getSession().getAttribute("USER_IN_SESSION");
		if (user == null) {
			resp.sendRedirect("/logon.jsp");
			return;
		}

		chain.doFilter(req, resp);//放行请求
	}

	@Override
	public void destroy() {
	}

}
