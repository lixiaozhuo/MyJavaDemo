package com.lixiaozhuo.dao;

import com.lixiaozhuo.domain.Product;
import com.lixiaozhuo.page.PageResult;
import com.lixiaozhuo.query.QueryObject;

//商品DAO接口
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
	 * 高级查询
	 * 
	 * @param objs
	 *            查询条件
	 * @return 信息集
	 */
	PageResult query(QueryObject obj);
	
}
