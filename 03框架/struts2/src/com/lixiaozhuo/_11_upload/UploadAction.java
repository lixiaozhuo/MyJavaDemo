package com.lixiaozhuo._11_upload;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import lombok.Setter;

//上传
public class UploadAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	@Setter
	private File headImg;
	@Setter
	private String headImgContentType;
	@Setter
	private String headImgFileName;

	@Override
	public String execute() throws Exception {
		System.out.println("headImg : " + headImg);
		System.out.println("headImgContentType : " + headImgContentType);
		System.out.println("headImgFileName : " + headImgFileName);

		// 获取上传文件的保存目录,绝对路径
		String path = ServletActionContext.getServletContext()
				.getRealPath("/upload");
		// 将文件拷贝到相关目录		
		FileUtils.copyFile(headImg, new File(path,headImgFileName));
		//删除临时文件
		headImg.delete();
		return NONE;
	}

}
