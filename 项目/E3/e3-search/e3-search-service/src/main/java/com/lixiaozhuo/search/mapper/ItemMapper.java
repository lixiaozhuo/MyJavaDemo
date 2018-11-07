package com.lixiaozhuo.search.mapper;

import java.util.List;

import com.lixiaozhuo.pojo.SearchItem;

/**
 * 商品查询接口
 * @author lxz
 *
 */
public interface ItemMapper {
	/**
	 * 获取商品列表信息
	 * @return
	 */
	List<SearchItem> getItemList();
	
	/**
	 * 根据id获取商品信息
	 * @param id  商品id
	 * @return
	 */
	SearchItem getItemById(long id);
}
