package com.lixiaozhuo.many2one.mapper;

import java.util.List;

import com.lixiaozhuo.many2one.domain.Employee;

public interface EmployeeMapper {
	void add(Employee obj);

	void update(Employee obj);

	void delete(Long id);

	Employee get(Long id);

	List<Employee> list();
}
