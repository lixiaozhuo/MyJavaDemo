package com.lixiaozhuo.controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

//文件上传和下载
@Controller
public class FileUpload {

	@RequestMapping("/upload")
	public void upload(MultipartFile file) throws IOException {
		System.out.println("文件类型 : " + file.getContentType());
		System.out.println("上传文件名称 : " + file.getName());
		System.out.println("文件原始名称 : " + file.getOriginalFilename());
		System.out.println("文件大小 : " + file.getSize());
		// 复制操作
		IOUtils.copy(file.getInputStream(), new FileOutputStream("C:/file/a.jpg"));
	}

	@RequestMapping("/download")
	public void download(HttpServletResponse response) throws Exception{
		//设置文件响应头
		response.setHeader("Content-Disposition", "attachment;filename=a.jpg");
		IOUtils.copy(new FileInputStream("C:/file/a.jpg"), response.getOutputStream());
	}
}
