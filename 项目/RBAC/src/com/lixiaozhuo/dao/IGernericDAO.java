package com.lixiaozhuo.dao;

import java.util.List;

import com.lixiaozhuo.page.PageResult;
import com.lixiaozhuo.query.QueryObject;

public interface IGernericDAO<T> {
	void save(T entity);

	void update(T entity);

	void delete(T entity);

	T get(Long id);

	List<T> list();
	
	/**
	 * 高级查询+分页查询
	 * @param qo 查询条件对象
	 * @return 查询结果对象
	 */
	PageResult<T> query(QueryObject qo);
}
