package com.lixiaozhuo.content.service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lixiaozhuo.mapper.TbContentCategoryMapper;
import com.lixiaozhuo.pojo.EasyUITreeNode;
import com.lixiaozhuo.pojo.TbContentCategory;
import com.lixiaozhuo.pojo.TbContentCategoryExample;
import com.lixiaozhuo.pojo.TbContentCategoryExample.Criteria;

/**
 * 内容分类业务逻辑
 * @author lxz
 *
 */
@Service
public class ContentCategoryServiceImpl implements ContentCategoryService {
	
	@Autowired
	private TbContentCategoryMapper contentCategoryMapper;

	@Override
	public List<EasyUITreeNode> getContentCategoryList(long parentId) {
		//根据parentId查询节点列表
		TbContentCategoryExample example = new TbContentCategoryExample();
		//设置查询条件
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		List<TbContentCategory> list = contentCategoryMapper.selectByExample(example);
		//转换成EasyUITreeNode格式
		List<EasyUITreeNode> result = new ArrayList<>();
		for (TbContentCategory tbContentCategory : list) {
			EasyUITreeNode node = new EasyUITreeNode();
			node.setId(tbContentCategory.getId());
			node.setText(tbContentCategory.getName());
			node.setState(tbContentCategory.getIsParent()?"closed" :"open");
			result.add(node);
		}
		return result;
	}

}
