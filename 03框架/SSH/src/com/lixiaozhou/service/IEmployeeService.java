package com.lixiaozhou.service;

import java.util.List;

import com.lixiaozhou.domain.Employee;

public interface IEmployeeService {
	void save(Employee obj);

	void update(Employee obj);

	void delete(Employee obj);

	Employee get(Long id);

	List<Employee> list();
}
