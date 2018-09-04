package com.lixiaozhuo._21_jdbc.dao;

import java.util.List;

import com.lixiaozhuo._21_jdbc.domain.Employee;

public interface IEmployeeDAO {
	void save(Employee obj);
	
	void update(Employee obj);
	
	void delete(Long id);
	
	Employee get(Long id );
	
	List<Employee> list();
}
