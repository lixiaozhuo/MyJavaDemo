package com.lixiaozhuo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lixiaozhuo.content.service.ContentService;
import com.lixiaozhuo.pojo.E3Result;
import com.lixiaozhuo.pojo.EasyUIDataGridResult;
import com.lixiaozhuo.pojo.TbContent;

/**
 * 网站内容控制器
 * @author lxz
 *
 */
@Controller
public class ContentController {
	/**
	 * 内容服务
	 */
	@Autowired
	private ContentService contentService;
	
	@RequestMapping("/content/list")
	@ResponseBody
	public EasyUIDataGridResult getContentList(Long categoryId,Integer page,Integer rows){
		//获取商品内容列表
		EasyUIDataGridResult result = contentService.getContentListByCid(categoryId, page, rows);
		return result;
	}
	
	@RequestMapping("/content/getContent")
	@ResponseBody
	public E3Result getAttributeContentList(Long id){
		//获取内容的content属性
		String content = contentService.getAttributeContent(id);
		return E3Result.ok(content);
	}
	
	@RequestMapping(value="/content/save",method=RequestMethod.POST)
	@ResponseBody
	public E3Result addContent(TbContent tbContent){
		//添加内容信息
		E3Result result = contentService.addContent(tbContent);
		return result;
	}
	
	@RequestMapping(value="/content/edit",method=RequestMethod.POST)
	@ResponseBody
	public E3Result editContent(TbContent tbContent){
		//更新内容信息
		E3Result result = contentService.updateContent(tbContent);
		return result;
	}
	
	@RequestMapping(value="/content/delete")
	@ResponseBody
	public E3Result deleteContent(String ids){
		//删除内容信息
		E3Result result = contentService.deleteContent(ids);
		return result;
	}
}
