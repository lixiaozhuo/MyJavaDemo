package com.liixiaozhuo.ajax._04_linkage;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.struts2.ServletActionContext;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.opensymphony.xwork2.ActionSupport;

import lombok.Setter;

//二级联动xml数据格式
public class LinkageByXmlAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	@Setter
	private Long pid;// 省份id

	@Override
	public String execute() throws Exception {
		List<Province> provinces = Province.getAllProvince();
		Document document = DocumentBuilderFactory.newInstance()
				.newDocumentBuilder().newDocument();
		// 创建根元素
		Element root = document.createElement("datas");
		document.appendChild(root);
		// 往根元素中添加省份元素
		for (Province province : provinces) {
			Element ele = document.createElement("data");
			ele.setAttribute("id", province.getId().toString());
			ele.setTextContent(province.getName());
			root.appendChild(ele);
		}

		// 响应
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/xml;charset=utf-8");
		// 将内存中的document对象转换输出到页面的outputStream
		TransformerFactory.newInstance().newTransformer().transform(
				new DOMSource(document),
				new StreamResult(response.getOutputStream()));
		return NONE;
	}

	public String getCityById() throws Exception {
		List<City> citys = City.getCityByProvinceId(pid);
		Document document = DocumentBuilderFactory.newInstance()
				.newDocumentBuilder().newDocument();
		// 创建根元素
		Element root = document.createElement("datas");
		document.appendChild(root);
		// 往根元素中添加城市元素
		for (City city : citys) {
			Element ele = document.createElement("data");
			ele.setAttribute("id", city.getId().toString());
			ele.setTextContent(city.getName());
			root.appendChild(ele);
		}

		// 响应
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/xml;charset=utf-8");
		// 将内存中的document对象转换输出到页面的outputStream
		TransformerFactory.newInstance().newTransformer().transform(
				new DOMSource(document),
				new StreamResult(response.getOutputStream()));
		return NONE;
	}

}
