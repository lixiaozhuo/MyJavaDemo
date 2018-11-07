package com.lixiaozhuo.item.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lixiaozhuo.item.pojo.Item;
import com.lixiaozhuo.pojo.TbItem;
import com.lixiaozhuo.pojo.TbItemDesc;
import com.lixiaozhuo.service.ItemService;

/**
 * 商品详情页展示
 * @author lxz
 *
 */
@Controller
public class ItemController {
	/**
	 * 商品详情Service
	 */
	@Autowired
	private ItemService itemService;
	
	@RequestMapping("/item/{itemId}")
	public String showItemInfo(@PathVariable Long itemId,Model model){
		//调用服务获取商品基本信息
		TbItem tbItem = itemService.getItemById(itemId);
		Item item = new Item(tbItem);
		//取商品描述信息
		TbItemDesc itemDesc = itemService.getItemDescById(itemId);
		//把信息传递给页面
		model.addAttribute("item", item);
		model.addAttribute("itemDesc", itemDesc);
		//返回逻辑视图
		return "item";
	}
}
