package com.lixiaozhuo._12_download;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import lombok.Getter;
import lombok.Setter;

//下载
public class DownloadAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	
	@Setter@Getter
	private String filename;
	@Override
	public String execute() throws Exception {	
		System.out.println(filename);
		return SUCCESS;
	}
	
	//使用stream返回类型,默认需要找Action中的inputStream属性,该属性必须返回InputStream
	public InputStream getInputStream() throws Exception{
		String path = ServletActionContext.getServletContext().getRealPath("/upload");
		File file = new File(path,filename);
		System.out.println(file);
		return new FileInputStream(file);
	}

}
