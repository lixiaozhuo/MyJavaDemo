package com.lixiaozhuo._01_upload;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

//上传文件处理
@WebServlet("/upload1")
public class FileUploadServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private List<String> list = Arrays.asList("jpg","png");
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 接收请求参数,封装成对象

		try {
			// 检查当前请求是否符合文件上传的规定
			if (ServletFileUpload.isMultipartContent(req)) {
				// 创建一个磁盘文件工厂
				DiskFileItemFactory factory = new DiskFileItemFactory();
				//设置工厂参数
				//factory.setSizeThreshold(1024 *1024);//设置内存存储大小
				//factory.setRepository(repository);//设置临时目录
				
				// 创建一个文件上传处理对象
				ServletFileUpload upload = new ServletFileUpload(factory);
				upload.setFileSizeMax(1024 * 3);//设置单个文件上传大小限制
				upload.setSizeMax(1024 * 5);//设置上传文件总大小限制

				// 解析请求
				List<FileItem> items = upload.parseRequest(req);
				for (FileItem fileItem : items) {					
					System.out.println("==========================");
					System.out.println("FileItem = " + fileItem);
					//获取上传字段的名称 ,name属性值
					System.out.println("name = " + fileItem.getFieldName());
					if (fileItem.isFormField()) {
						//表单字段
						System.out.println("value = " + fileItem.getString("utf-8"));
					} else {
						System.out.println("是否存在在内存中:" + fileItem.isInMemory());						
						//二进制数据
						String filename = fileItem.getName();
						//判断上传文件类型是否正确
						if(!list.contains(FilenameUtils.getExtension(filename))){
							req.setAttribute("erroFile", "文件类型错误");
							req.getRequestDispatcher("/upload.jsp").forward(req, resp);
							return ;
						}
						
						System.out.println("文件名:" + filename);// 上传的文件名
						System.out.println("文件名称(单名称):" + FilenameUtils.getName(filename));
						System.out.println("文件名后缀:" + FilenameUtils.getExtension(filename));
						System.out.println("文件名无后缀:" + FilenameUtils.getBaseName(filename));
						
						String newFilename = UUID.randomUUID().toString() +"."+ FilenameUtils.getExtension(filename);
						System.out.println("新文件名:" + newFilename);
						//上传文件夹绝对路径
						String dir = getServletContext().getRealPath("/upload");
						System.out.println("上传文件夹绝对路径" + dir);
						fileItem.write(new File(dir, newFilename));
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 调用业务方法,处理请求
		// 控制页面跳转
	}
}
