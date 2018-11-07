package com.lixiaozhuo.service;

import com.lixiaozhuo.pojo.E3Result;
import com.lixiaozhuo.pojo.EasyUIDataGridResult;
import com.lixiaozhuo.pojo.TbItem;
import com.lixiaozhuo.pojo.TbItemDesc;
/**
 * 商品服务接口
 * @author lxz
 *
 */
public interface ItemService {
	
	
	/**
	 * 根据id获取商品
	 * @param itemId 商品id
	 * @return 商品信息
	 */
	TbItem getItemById(long itemId);
	
	/**
	 * 根据id获取商品详情
	 * @param itemId 商品id
	 * @return 商品详情信息
	 */
	TbItemDesc getItemDescById(long itemId);
	
	/**
	 * 获取商品列表
	 * @param pageNum 起始页
	 * @param pageSize 页面大小
	 * @return 界面表格数据
	 */
	EasyUIDataGridResult getItemList(Integer pageNum,Integer pageSize);
	
	/**
	 * 添加商品
	 * @param item 商品数据
	 * @param desc 商品详情
	 * @return 响应结果
	 */
	E3Result addItem(TbItem item,String desc);
	
	/**
	 * 更新商品信息
	 * @param item 商品数据
	 * @param desc 商品详情
	 * @return 响应结果
	 */
	E3Result updateItem(TbItem item,String desc);
	
	/**
	 * 删除商品(包含批量删除)
	 * @param itemIds 商品id集合
	 * @return 响应结果
	 */
	E3Result deleteItem(String itemIds);
	
	/**
	 * 下架商品(包括批量下架)
	 * @param itemIds 商品id集合
	 * @return 响应结果
	 */
	E3Result instockItem(String itemIds);
	/**
	 * 上架商品(包括批量上架)
	 * @param itemIds 商品id集合
	 * @return 响应结果
	 */
	E3Result reshelfItem(String itemIds);
}
