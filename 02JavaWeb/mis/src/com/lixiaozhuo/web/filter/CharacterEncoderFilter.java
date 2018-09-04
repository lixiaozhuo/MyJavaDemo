package com.lixiaozhuo.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.mysql.cj.util.StringUtils;

//编码方式过滤器
public class CharacterEncoderFilter implements Filter {

	private String encode;//编码方式
	private Boolean fore;//是否覆盖

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		encode = filterConfig.getInitParameter("encode");
		fore = Boolean.valueOf(filterConfig.getInitParameter("fore"));
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		//System.out.println("encode = " + encode);
		//System.out.println("fore = " + fore);
		if(fore == true && !StringUtils.isEmptyOrWhitespaceOnly(encode)){
			request.setCharacterEncoding(encode);
			//System.out.println("执行编码设置");
		}		
		chain.doFilter(request, response);//放行请求

	}

	@Override
	public void destroy() {
	}

}
