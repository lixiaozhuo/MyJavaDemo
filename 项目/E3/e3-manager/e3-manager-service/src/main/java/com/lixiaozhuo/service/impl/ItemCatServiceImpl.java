package com.lixiaozhuo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lixiaozhuo.mapper.TbItemCatMapper;
import com.lixiaozhuo.pojo.EasyUITreeNode;
import com.lixiaozhuo.pojo.TbItemCat;
import com.lixiaozhuo.pojo.TbItemCatExample;
import com.lixiaozhuo.pojo.TbItemCatExample.Criteria;
import com.lixiaozhuo.service.ItemCatService;

/**
 * 商品分类服务
 * @author lxz
 *
 */
@Service
public class ItemCatServiceImpl implements ItemCatService {
	/**
	 * 商品分类Mapper
	 */
	@Autowired
	private TbItemCatMapper itemCatMapper;
	

	@Override
	public List<EasyUITreeNode> getItemCatList(long parentId) {
		//根据parentId查询节点列表
		TbItemCatExample example = new TbItemCatExample();
		//设置查询条件
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		//执行查询
		List<TbItemCat> list = itemCatMapper.selectByExample(example);
		//转换成EasyUITreeNode 列表
		List<EasyUITreeNode> result = new ArrayList<>();
		for (TbItemCat tbItemCat : list) {
			EasyUITreeNode node = new EasyUITreeNode();
			node.setId(tbItemCat.getId());
			node.setText(tbItemCat.getName());
			node.setState(tbItemCat.getIsParent()?"closed" :"open");
			result.add(node);
		}	
		//返回查询结果
		return result;
	}

}
