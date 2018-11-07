package com.lixiaozhuo.content.service;

import java.util.List;

import com.lixiaozhuo.pojo.EasyUITreeNode;

/**
 * 内容分类业务接口
 * @author lxz
 *
 */
public interface ContentCategoryService {
	/**
	 * 获取内容分类列表
	 * @param parentId 父节点id
	 * @return
	 */
	List<EasyUITreeNode> getContentCategoryList(long parentId);
}
