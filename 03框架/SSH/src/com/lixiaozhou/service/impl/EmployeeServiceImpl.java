package com.lixiaozhou.service.impl;

import java.util.List;

import com.lixiaozhou.dao.IEmployeeDAO;
import com.lixiaozhou.domain.Employee;
import com.lixiaozhou.service.IEmployeeService;

import lombok.Setter;

public class EmployeeServiceImpl implements IEmployeeService {
	@Setter
	private IEmployeeDAO employeeDAO;

	@Override
	public void save(Employee obj) {
		employeeDAO.save(obj);
	}

	@Override
	public void update(Employee obj) {
		employeeDAO.update(obj);
	}

	@Override
	public void delete(Employee obj) {
		employeeDAO.delete(obj);
	}

	@Override
	public Employee get(Long id) {
		return employeeDAO.get(id);
	}

	@Override
	public List<Employee> list() {
		return employeeDAO.list();
	}

}
