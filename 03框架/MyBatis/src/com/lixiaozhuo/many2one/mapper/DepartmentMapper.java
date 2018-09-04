package com.lixiaozhuo.many2one.mapper;

import java.util.List;

import com.lixiaozhuo.many2one.domain.Department;

public interface DepartmentMapper {
	void add(Department obj);

	void update(Department obj);

	void delete(Long id);

	Department get(Long id);

	List<Department> list();
}
