package com.lixiaozhuo.content.service;

import java.util.List;

import com.lixiaozhuo.pojo.E3Result;
import com.lixiaozhuo.pojo.EasyUIDataGridResult;
import com.lixiaozhuo.pojo.TbContent;

/**
 * 网站内容服务接口
 * @author lxz
 *
 */
public interface ContentService {
	
	
	/**
	 * 获取指定分类所有内容(门户网站数据)
	 * @param cid 内容分类id
	 * @return 内容列表
	 */
	List<TbContent> getContentByCid(long cid);
	
	/**
	 * 获取指定内容的Content属性
	 * @param id 商品内容id
	 * @return Content属性
	 */
	String getAttributeContent(long id);
	
	/**
	 * 获取指定分类内容列表(管理界面数据)
	 * @param categoryId 商品分类id
	 * @param pageNum 当前页
	 * @param pageSize 页面大小
	 * @return 内容列表
	 */
	EasyUIDataGridResult getContentListByCid(long categoryId,Integer pageNum, Integer pageSize);
	
	/**
	 * 添加内容
	 * @param tbContent 内容
	 * @return 响应消息
	 */
	E3Result addContent(TbContent tbContent);
	
	/**
	 * 更新内容
	 * @param tbContent 新内容
	 * @return 响应消息
	 */
	E3Result updateContent(TbContent tbContent);
	
	/**
	 * 删除内容
	 * @param ids 内容id集合
	 * @return 响应消息
	 */
	E3Result deleteContent(String contentIds);
	
}
