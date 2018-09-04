package com.lixiaozhuo._19_aop_annon.aop_common.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lixiaozhuo._19_aop_annon.aop_common.dao.IEmployeeDAO;
import com.lixiaozhuo._19_aop_annon.aop_common.domain.Employee;
import com.lixiaozhuo._19_aop_annon.aop_common.service.IEmployeeService;

@Service("enplService")
public class EmployeeServiceImpl implements IEmployeeService {
	@Autowired
	private IEmployeeDAO emplDAO;

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
