package com.lixiaozhuo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lixiaozhuo.pojo.E3Result;
import com.lixiaozhuo.search.service.SearchItemService;

/**
 * 导入商品到索引库
 * @author lxz
 *
 */
@Controller
public class SearchItemController {
	/**
	 * 搜索商品服务
	 */
	@Autowired
	private SearchItemService searchItemService;
	
	@RequestMapping("/index/item/import")
	@ResponseBody
	public E3Result importItemList(){
		//将商品数据导入索引库中
		E3Result result = searchItemService.importAllItems();
		//返回响应结果
		return result;
	}
}
