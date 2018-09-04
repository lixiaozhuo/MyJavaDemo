package com.liixiaozhuo.ajax._04_linkage;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import lombok.Setter;

//二级联动html数据格式
public class LinkageByHtmlAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	@Setter
	private Long pid;//省份id

	@Override
	public String execute() throws Exception {
		List<Province> provinces = Province.getAllProvince();
		//创建html代码
		StringBuilder sb = new StringBuilder(80);
		for (Province province : provinces) {
			sb.append("<option value='" + province.getId() + "'>"
					+ province.getName() + "</option>");
		}
		//响应
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().println(sb.toString());
		return NONE;
	}
	
	public String getCityById() throws Exception {
		List<City> citys = City.getCityByProvinceId(pid);
		//创建html代码
		StringBuilder sb = new StringBuilder(80);
		for (City city : citys) {
			sb.append("<option value='" + city.getId() + "'>"
					+ city.getName() + "</option>");
		}
		//响应
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().println(sb.toString());
		return NONE;
	}


}
