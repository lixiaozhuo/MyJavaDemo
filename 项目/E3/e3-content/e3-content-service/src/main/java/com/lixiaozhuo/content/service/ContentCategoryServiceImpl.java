package com.lixiaozhuo.content.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lixiaozhuo.mapper.TbContentCategoryMapper;
import com.lixiaozhuo.pojo.E3Result;
import com.lixiaozhuo.pojo.EasyUITreeNode;
import com.lixiaozhuo.pojo.TbContentCategory;
import com.lixiaozhuo.pojo.TbContentCategoryExample;
import com.lixiaozhuo.pojo.TbContentCategoryExample.Criteria;

/**
 * 网站内容分类服务
 * 
 * @author lxz
 *
 */
@Service
public class ContentCategoryServiceImpl implements ContentCategoryService {
	/**
	 * 内容分类Mapper
	 */
	@Autowired
	private TbContentCategoryMapper contentCategoryMapper;

	@Override
	public List<EasyUITreeNode> getContentCategoryList(long parentId) {
		// 根据父节点查询节点列表
		TbContentCategoryExample example = new TbContentCategoryExample();
		// 设置查询条件
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		//查询
		List<TbContentCategory> list = contentCategoryMapper
				.selectByExample(example);
		// 转换成EasyUITreeNode 列表
		List<EasyUITreeNode> result = new ArrayList<>();
		for (TbContentCategory tbContentCategory : list) {
			EasyUITreeNode node = new EasyUITreeNode();
			node.setId(tbContentCategory.getId());
			node.setText(tbContentCategory.getName());
			node.setState(tbContentCategory.getIsParent() ? "closed" : "open");
			result.add(node);
		}
		//返回结果
		return result;
	}

	@Override
	public E3Result addContentCategory(TbContentCategory contentCategory) {
		// 补全分类对象属性
		contentCategory.setIsParent(false);
		// 排列序号,表示同级类目的展现次序,如数值相等则按照名称次序排列.取值范围:大于零的整数
		contentCategory.setSortOrder(1);
		// 状态 1(正常)2(删除)
		contentCategory.setStatus(1);
		//创建和更新日期
		contentCategory.setCreated(new Date());
		contentCategory.setUpdated(new Date());
		// 向tb_content_category表中插入数据(设置主键返回策略,对象中包含主键)
		contentCategoryMapper.insert(contentCategory);
		// 判断父节点的ispartent是否为true,不是true则改为true
		TbContentCategory parentNode = contentCategoryMapper
				.selectByPrimaryKey(contentCategory.getParentId());
		if (!parentNode.getIsParent()) {
			// 更新父节点的ispartent
			parentNode.setIsParent(true);
			// 更新父节点信息到数据库
			contentCategoryMapper.updateByPrimaryKey(parentNode);
		}
		// 返回响应对象
		return E3Result.ok(contentCategory);
	}

	@Override
	public E3Result updateContentCategory(TbContentCategory contentCategory) {
		// 设置分类对象的更新日期
		contentCategory.setUpdated(new Date());
		// 执行更新
		contentCategoryMapper.updateByPrimaryKeySelective(contentCategory);
		// 返回响应对象
		return E3Result.ok();
	}

	@Override
	public E3Result deleteContentCategory(Long id) {
		// 查询节点是否有子节点
		TbContentCategory contentCategory = contentCategoryMapper
				.selectByPrimaryKey(id);
		if (contentCategory.getIsParent()) {
			return E3Result.build(500, "此节点存在子节点,请确保节点无子节点后执行删除");
		}
		// 执行删除
		contentCategoryMapper.deleteByPrimaryKey(id);
		// 查询父节点是否为叶子节点
		// 获取父节点id
		Long parentId = contentCategory.getParentId();
		//设置查询条件
		TbContentCategoryExample example = new TbContentCategoryExample();
		TbContentCategoryExample.Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		//查询父节点所有子节点
		List<TbContentCategory> contentCategoriesByParent = contentCategoryMapper
				.selectByExample(example);
		//父节点没有子节点,更新其为叶子节点
		if(contentCategoriesByParent.size() == 0){
			//更新父节点为叶子节点
			TbContentCategory parent = contentCategoryMapper.selectByPrimaryKey(parentId);
			parent.setIsParent(false);
			//更新更改时间
			parent.setUpdated(new Date());
			//执行更新
			contentCategoryMapper.updateByPrimaryKeySelective(parent);
		}
		// 返回响应对象
		return E3Result.ok();
	}

}
