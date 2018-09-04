package com.lixiaozhuo.many2one.service;

import java.util.List;

import com.lixiaozhuo.many2one.domain.Department;

public interface IDepartmentService {
	void save(Department obj);
	
	void update(Department obj);
	
	void delete(Long id);
	
	Department get(Long id);
	
	List<Department> list();
}
