package com.lixiaozhuo._02_utils;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase.FileSizeLimitExceededException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

import com.lixiaozhuo.exception.FileTypeException;

//上传文件工具
public class FileUploadUtils {
	private FileUploadUtils(){}
	public static Map<String,Object> fileUpload(HttpServletRequest req){
		try {
			// 检查当前请求是否符合文件上传的规定
			if (ServletFileUpload.isMultipartContent(req)) {
				// 创建一个磁盘文件工厂
				DiskFileItemFactory factory = new DiskFileItemFactory();
				// 创建一个文件上传处理对象
				ServletFileUpload upload = new ServletFileUpload(factory);
				upload.setFileSizeMax(1024 * 3);//设置单个文件上传大小限制
				//upload.setSizeMax(1024 * 5);//设置上传文件总大小限制
				
				Map<String,Object> map = new HashMap<>();
				// 解析请求
				List<FileItem> items = upload.parseRequest(req);
				for (FileItem fileItem : items) {					
					if (fileItem.isFormField()) {
						//表单字段
						map.put(fileItem.getFieldName(), fileItem.getString("UTF-8"));
					} else {
						//二进制数据
						String filename = fileItem.getName();
						//判断上传文件类型是否正确
						//获取上传文件的MIME类型
						if(!fileItem.getContentType().startsWith("image/")){
							throw new FileTypeException("文件类型错误");
						}						
						String newFilename = UUID.randomUUID().toString() +"."+ FilenameUtils.getExtension(filename);
						//上传文件夹绝对路径
						String dir = req.getServletContext().getRealPath("/upload");
						fileItem.write(new File(dir, newFilename));
						map.put("filename", filename);
						map.put("path", "/upload" + newFilename);
					}
				}
				return map;
			}
		}catch(FileSizeLimitExceededException e){
			throw new RuntimeException("文件大小超过限制");
		}catch(FileTypeException e){
			throw e;
		}catch(Exception e){
			e.printStackTrace();	
		}
		return null;
	}
}
