package com.lixiaozhuo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.lixiaozhuo.utils.FastDFSClient;
import com.lixiaozhuo.utils.JsonUtils;

/**
 * 图片上传控制器
 * @author lxz
 *
 */
@Controller
public class PictureController {
	/**
	 * 图片上传服务器地址
	 */
	@Value("${IMAGE_SERVER_URL}")
	private String IMAGE_SERVER_URL;
	
	@RequestMapping(value="/pic/upload",produces=MediaType.TEXT_PLAIN_VALUE +";charset=UTF-8")
	@ResponseBody
	public String fileUpload(MultipartFile uploadFile){
		try{
			//获取文件扩展名
			String originalFilename = uploadFile.getOriginalFilename();
			String extName = originalFilename.substring(originalFilename.lastIndexOf(".")+1);
			//创建一个FastDFS的客户端呢
			FastDFSClient fastDFSClient = new FastDFSClient("classpath:confg/client.conf");
			//执行上传处理
			String path = fastDFSClient.uploadFile(uploadFile.getBytes(),extName);
			//拼接返回的url和ip地址,拼装成完整的url
			String url = IMAGE_SERVER_URL + path;
			//返回map
			Map<String,Object> result = new HashMap<>();
			result.put("error", 0);
			result.put("url",url);
			//返回响应消息
			return JsonUtils.objectToJson(result);
		}catch(Exception e){
			e.printStackTrace();
			//返回map
			Map<String,Object> result = new HashMap<>();
			result.put("error", 1);
			result.put("message","图片上传失败");
			//返回响应消息
			return JsonUtils.objectToJson(result);
		}
	}
	
	
}
