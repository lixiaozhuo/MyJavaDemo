package com.lixiaozhuo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lixiaozhuo.content.service.ContentCategoryService;
import com.lixiaozhuo.pojo.E3Result;
import com.lixiaozhuo.pojo.EasyUITreeNode;
import com.lixiaozhuo.pojo.TbContentCategory;

/**
 * 网页内容分类控制器
 * 
 * @author lxz
 *
 */
@Controller
@RequestMapping("/content/category/")
public class ContentCategoryController {
	/**
	 * 分类Service
	 */
	@Autowired
	private ContentCategoryService contentCategoryService;

	@RequestMapping("/list")
	@ResponseBody
	public List<EasyUITreeNode> getContentCategoryList(
			@RequestParam(value = "id", defaultValue = "0") Long parentId) {
		// 获取指定内容分类列表
		List<EasyUITreeNode> categoryList = contentCategoryService
				.getContentCategoryList(parentId);
		return categoryList;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@ResponseBody
	public E3Result createContentCategory(TbContentCategory contentCategory) {
		// 添加内容分类节点
		E3Result result = contentCategoryService
				.addContentCategory(contentCategory);
		return result;
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public E3Result updateContentCategory(TbContentCategory contentCategory) {
		// 更新内容分类节点
		E3Result result = contentCategoryService
				.updateContentCategory(contentCategory);
		return result;
	}
	
	@RequestMapping(value = "/delete")
	@ResponseBody
	public E3Result deleteContentCategory(Long id) {
		// 删除内容分类节点
		E3Result result = contentCategoryService
				.deleteContentCategory(id);
		return result;
	}

}
