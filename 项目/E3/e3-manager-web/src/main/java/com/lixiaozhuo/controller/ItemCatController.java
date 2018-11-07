package com.lixiaozhuo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lixiaozhuo.pojo.EasyUITreeNode;
import com.lixiaozhuo.service.ItemCatService;

/**
 * 商品分类管理
 * 
 * @author lxz
 *
 */
@Controller
public class ItemCatController {
	/**
	 * 商品分类服务
	 */
	@Autowired
	private ItemCatService itemCatService;

	@RequestMapping("/item/cat/list")
	@ResponseBody
	public List<EasyUITreeNode> getItemCatList(
			@RequestParam(value = "id", defaultValue = "0") Long parentId) {
		//获取指定商品分类列表
		List<EasyUITreeNode> catList = itemCatService.getItemCatList(parentId);
		return catList;
	}
}
