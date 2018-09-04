package com.lixiaozhuo.many2one.service;

import java.util.List;

import com.lixiaozhuo.many2one.domain.Employee;

public interface IEmployeeService {
	void save(Employee obj);
	
	void update(Employee obj);
	
	void delete(Long id);
	
	Employee get(Long id);
	
	List<Employee> list();
}
