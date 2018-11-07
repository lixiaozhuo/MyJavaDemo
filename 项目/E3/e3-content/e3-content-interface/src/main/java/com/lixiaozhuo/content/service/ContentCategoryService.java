package com.lixiaozhuo.content.service;

import java.util.List;

import com.lixiaozhuo.pojo.E3Result;
import com.lixiaozhuo.pojo.EasyUITreeNode;
import com.lixiaozhuo.pojo.TbContentCategory;

/**
 *	网站内容分类服务接口
 * 
 * @author lxz
 *
 */
public interface ContentCategoryService {
	/**
	 * 获取内容分类列表
	 * 
	 * @param parentId
	 *            父节点id
	 * @return 内容分类列表
	 */
	List<EasyUITreeNode> getContentCategoryList(long parentId);

	/**
	 * 添加内容分类
	 * @param contentCategory 内容分类
	 * @return 响应消息
	 */
	E3Result addContentCategory(TbContentCategory contentCategory);

	/**
	 * 更新内容分类
	 * @param contentCategory  新内容分类
	 * @return 响应消息
	 */
	E3Result updateContentCategory(TbContentCategory contentCategory);
	
	/**
	 * 删除内容分类
	 * @param id 内容分类id
	 * @return  响应消息
	 */
	E3Result deleteContentCategory(Long id);
}
