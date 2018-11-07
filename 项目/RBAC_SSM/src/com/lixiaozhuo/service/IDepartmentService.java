package com.lixiaozhuo.service;

import java.util.List;

import com.lixiaozhuo.domain.Department;
import com.lixiaozhuo.page.PageResult;
import com.lixiaozhuo.query.QueryObject;

public interface IDepartmentService {
	void save(Department entity);
	
	void update(Department entity);
	
	void delete(Long id);
	
	Department get(Long id);
	
	List<Department> list();
	
	PageResult<Department> query(QueryObject qo);
}
