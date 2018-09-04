package com.liixiaozhuo.ajax._04_linkage;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import lombok.Setter;

//二级联动JSON数据格式
public class LinkageByJsonAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	@Setter
	private Long pid;// 省份id

	@Override
	public String execute() throws Exception {
		List<Province> provinces = Province.getAllProvince();
		// 拼接json对象
		StringBuilder sb = new StringBuilder(80);
		sb.append("[");
		for (Province province : provinces) {
			sb.append("{id:" + province.getId());
			sb.append(",name:'" + province.getName());
			sb.append("'},");
		}
		sb.deleteCharAt(sb.length() - 1);
		sb.append("]");
		// 响应
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/json;charset=utf-8");
		response.getWriter().println(sb.toString());
		return NONE;
	}

	public String getCityById() throws Exception {
		List<City> citys = City.getCityByProvinceId(pid);
		// 拼接json对象
		StringBuilder sb = new StringBuilder(80);
		sb.append("[");
		for (City city : citys) {
			sb.append("{id:" + city.getId());
			sb.append(",name:'" + city.getName());
			sb.append("'},");
		}
		sb.deleteCharAt(sb.length() - 1);
		sb.append("]");
		// 响应
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/json;charset=utf-8");
		response.getWriter().println(sb.toString());
		return NONE;
	}

}
