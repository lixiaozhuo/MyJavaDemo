package com.lixiaozhuo.dao;

import java.util.List;

import com.lixiaozhuo.domain.Product;
import com.lixiaozhuo.page.PageResult;
import com.lixiaozhuo.query.QueryObject;

//DAO接口
public interface IProductDAO {
	/**
	 * 保存信息
	 * 
	 * @param obj
	 *            要保存的信息
	 */
	void save(Product obj);

	/**
	 * 更新信息
	 * 
	 * @param obj
	 *            要更新的信息
	 */
	void update(Product obj);

	/**
	 * 删除指定id信息
	 * 
	 * @param id
	 *            要删除信息的id
	 */
	void delete(Long id);

	/**
	 * 得到指定id信息
	 * 
	 * @param id
	 *            要查询的信息id
	 * @return 查询的信息
	 */
	Product get(Long id);

	/**
	 * 得到所有信息
	 * 
	 * @return 所有信息集
	 */
	List<Product> list();
	
	/**
	 * 得到部分信息
	 * @param objs 查询条件
	 * @return 指定信息集
	 */
	List<Product> queryCondition(QueryObject objs);
	
	/**
	 * 分页查询
	 * @param currentPage 当前页
	 * @param pageSize 每页显示记录数
	 * @return 信息集
	 */
	PageResult queryPage(Integer currentPage,Integer pageSize);
	
	/**
	 * 高级查询
	 * @param objs 查询条件
	 * @return 信息集
	 */
	PageResult query(QueryObject objs);
}
