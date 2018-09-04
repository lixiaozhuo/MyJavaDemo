package com.lixiaozhuo.one2many.service;

import java.util.List;

import com.lixiaozhuo.one2many.domain.Department;

public interface IDepartmentService {
	void save(Department obj);

	void update(Department obj);

	void delete(Long id);

	Department get(Long id);

	List<Department> list();
}
