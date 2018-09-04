package com.lixiaozhuo._20_aop_common.dao.impl;

import com.lixiaozhuo._20_aop_common.dao.IEmployeeDAO;
import com.lixiaozhuo._20_aop_common.domain.Employee;

public class EmployeeDAOImpl implements IEmployeeDAO {

	@Override
	public void save(Employee obj) {
		System.out.println("DAO保存对象........");
	}

	@Override
	public void update(Employee obj) {
		System.out.println("DAO更新对象........");
	}

}
