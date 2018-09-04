package com.lixiaozhuo._20_aop_common.service.impl;

import com.lixiaozhuo._20_aop_common.dao.IEmployeeDAO;
import com.lixiaozhuo._20_aop_common.dao.impl.EmployeeDAOImpl;
import com.lixiaozhuo._20_aop_common.domain.Employee;
import com.lixiaozhuo._20_aop_common.service.IEmployeeService;

import lombok.Setter;

public class EmployeeServiceImpl implements IEmployeeService {
	@Setter
	private IEmployeeDAO emplDAO = new EmployeeDAOImpl();

	@Override
	public void save(Employee obj) {
		emplDAO.save(obj);
	}

	@Override
	public void update(Employee obj) {
		emplDAO.update(obj);
		throw new RuntimeException("出错测试");
	}

}
