package com.lixiaozhuo.mapper;

import java.util.List;

import com.lixiaozhuo.query.QueryObject;

public interface IGernericMapper <T> {
	void save(T obj);

	void update(T obj);

	void delete(Long id);

	T get(Long id);

	List<T> list();
	
	/**
	 * 查询数据总数
	 */
	Long queryCount(QueryObject qo);
	
	/**
	 * 高级查询+分页查询
	 * @param qo 查询条件对象
	 * @return 查询结果对象
	 */
	List<T> query(QueryObject qo);
}
