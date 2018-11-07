package com.lixiaozhuo.cart.service;

import java.util.List;

import com.lixiaozhuo.pojo.E3Result;
import com.lixiaozhuo.pojo.TbItem;

/**
 * 购物车服务
 * @author lxz
 *
 */
public interface CartService {
	
	/**
	 * 用户添加购物车
	 * @param userId 用户id
	 * @param itemId 商品id
	 * @param num 商品数量
	 * @return
	 */
	E3Result addCartItem(long userId,long itemId,int num);
	
	/**
	 * 合并购物车
	 * @param userId 用户id
	 * @param itemList 商品列表
	 * @return
	 */
	E3Result mergeCartItem(long userId,List<TbItem> itemList);
	
	/**
	 * 获得购物车列表
	 * @param userId 用户id
	 * @return 购物车列表
	 */
	List<TbItem> getCartItem(long userId);
	
	/**
	 * 用户更新购物车
	 * @param userId 用户id
	 * @param itemId 商品id
	 * @param num 商品数量
	 * @return
	 */
	E3Result updateCartNum(long userId,long itemId,int num);
	
	/**
	 * 用户删除购物车
	 * @param userId 用户id
	 * @param itemId 商品id
	 * @return
	 */
	E3Result deleteCartItem(long userId,long itemId);
	
	/**
	 * 清空购物车
	 * @param userId
	 * @return
	 */
	E3Result clearCartItem(long userId);
}
