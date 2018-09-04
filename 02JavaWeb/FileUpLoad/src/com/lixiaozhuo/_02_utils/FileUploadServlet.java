package com.lixiaozhuo._02_utils;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//使用上传文件工具来处理上传文件请求
@WebServlet("/upload")
public class FileUploadServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 接收请求参数,封装成对象
		try {
			Map<String, Object> upload = FileUploadUtils.fileUpload(req);
			System.out.println(upload);
		} catch (Exception e) {
			req.setAttribute("errorMsg", e.getMessage());
			req.getRequestDispatcher("/upload.jsp").forward(req, resp);
		}

		// 调用业务方法,处理请求
		// 控制页面跳转
	}
}
