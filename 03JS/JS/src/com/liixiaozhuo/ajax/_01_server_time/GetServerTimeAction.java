package com.liixiaozhuo.ajax._01_server_time;

import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

//获取服务器时间
public class GetServerTimeAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	
	@Override
	public String execute() throws Exception {
		//模拟网络延迟
		//Thread.sleep(1000);		
		@SuppressWarnings("deprecation")
		String time = new Date().toLocaleString();
		//输出服务端时间
		HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("text/text;charset=utf-8"); 
        response.setCharacterEncoding("UTF-8");
        response.getWriter().println(time);		
		return NONE;
	}
}
