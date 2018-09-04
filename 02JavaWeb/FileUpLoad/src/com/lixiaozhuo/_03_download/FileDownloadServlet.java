package com.lixiaozhuo._03_download;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//文件下载请求处理
@WebServlet("/download")
public class FileDownloadServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 接收请求参数,封装成对象
		String filename = req.getParameter("filename");
		String path = getServletContext().getRealPath("/upload");
		System.out.println(req.getHeader("User-Agent"));
		String name = null;
		//设置下载名
		if(req.getHeader("User-Agent").contains("Firefox")){
			//火狐
			name = new String(filename.getBytes("UTF-8"),"ISO-8859-1");
		}else{
			name = URLEncoder.encode(filename, "UTF-8");
		}
		
		// 1.设置文件ContentType类型，这样设置，会自动判断下载文件类型
		resp.setContentType("multipart/form-data");
		// 2.设置文件头：最后一个参数是设置下载文件名
		resp.setHeader("Content-Disposition", "attachment;fileName=" + name);
		// 把数据响应给浏览器
		Files.copy(Paths.get(path + "/" + filename), resp.getOutputStream());
	}
}
