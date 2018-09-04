package com.lixiaozhuo.one2many.service;

import java.util.List;

import com.lixiaozhuo.one2many.domain.Employee;

public interface IEmployeeService {
	void save(Employee obj);

	void update(Employee obj);

	void delete(Long id);

	Employee get(Long id);

	List<Employee> list();
}
