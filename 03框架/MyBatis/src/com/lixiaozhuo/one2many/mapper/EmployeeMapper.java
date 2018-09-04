package com.lixiaozhuo.one2many.mapper;

import java.util.List;

import com.lixiaozhuo.one2many.domain.Employee;

public interface EmployeeMapper {
	void add(Employee obj);

	void update(Employee obj);

	void delete(Long id);

	Employee get(Long id);
	
	Employee getByDept(Long deptId);

	List<Employee> list();
}