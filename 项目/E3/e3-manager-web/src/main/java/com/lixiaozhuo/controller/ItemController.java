package com.lixiaozhuo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lixiaozhuo.pojo.E3Result;
import com.lixiaozhuo.pojo.EasyUIDataGridResult;
import com.lixiaozhuo.pojo.TbItem;
import com.lixiaozhuo.pojo.TbItemDesc;
import com.lixiaozhuo.service.ItemService;

/**
 * 商品管理
 * @author lxz
 *
 */
@Controller
public class ItemController {
	/**
	 * 商品服务
	 */
	@Autowired
	private ItemService itemService;
	
	@RequestMapping("/item/{itemId}")
	@ResponseBody
	public TbItem getItemById(@PathVariable Long itemId){
		//获取指定id商品
		TbItem tbItem = itemService.getItemById(itemId);
		return tbItem;
	}
	
	@RequestMapping("/item/desc/{itemId}")
	@ResponseBody
	public E3Result getItemDescById(@PathVariable Long itemId){
		//获取指定id商品详情(数据回显)
		TbItemDesc itemDesc = itemService.getItemDescById(itemId);
		return E3Result.ok(itemDesc);
	}
	
	@RequestMapping("/item/list")
	@ResponseBody
	public EasyUIDataGridResult getItemList(Integer page,Integer rows){
		//获取商品列表
		EasyUIDataGridResult result = itemService.getItemList(page, rows);
		return result;
	}
	
	@RequestMapping(value="/item/save",method=RequestMethod.POST)
	@ResponseBody
	public E3Result saveItem(TbItem item,String desc){
		//增加商品
		E3Result result = itemService.addItem(item, desc);
		return result;
	}
	
	@RequestMapping(value="/item/update",method=RequestMethod.POST)
	@ResponseBody
	public E3Result updateItem(TbItem item,String desc){
		//更新商品
		E3Result result = itemService.updateItem(item, desc);
		return result;
	}
	
	@RequestMapping(value="/item/delete")
	@ResponseBody
	public E3Result deleteItem(String ids){
		//删除商品
		E3Result result = itemService.deleteItem(ids);
		return result;
	}

	@RequestMapping(value="/item/instock")
	@ResponseBody
	public E3Result instockItem(String ids){
		//下架商品
		E3Result result = itemService.instockItem(ids);
		return result;
	}
	
	@RequestMapping(value="/item/reshelf")
	@ResponseBody
	public E3Result reshelfItem(String ids){
		//上架商品
		E3Result result = itemService.reshelfItem(ids);
		return result;
	}
	
	
}
