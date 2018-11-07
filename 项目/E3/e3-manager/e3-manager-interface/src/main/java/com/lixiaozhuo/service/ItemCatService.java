package com.lixiaozhuo.service;

import java.util.List;

import com.lixiaozhuo.pojo.EasyUITreeNode;

/**
 * 商品分类服务接口
 * @author lxz
 *
 */
public interface ItemCatService {
	/**
	 * 获取商品分类列表
	 * @param parentId 父节点id
	 * @return 商品分类列表
	 */
	List<EasyUITreeNode> getItemCatList(long parentId);
}
