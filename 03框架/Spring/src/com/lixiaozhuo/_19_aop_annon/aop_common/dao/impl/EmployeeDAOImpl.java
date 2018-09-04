package com.lixiaozhuo._19_aop_annon.aop_common.dao.impl;

import org.springframework.stereotype.Repository;

import com.lixiaozhuo._19_aop_annon.aop_common.dao.IEmployeeDAO;
import com.lixiaozhuo._19_aop_annon.aop_common.domain.Employee;

@Repository("emplDAO")
public class EmployeeDAOImpl implements IEmployeeDAO {

	@Override
	public void save(Employee u) {
		System.out.println("DAO保存对象........");
	}

	@Override
	public void update(Employee obj) {
		System.out.println("DAO更新对象........");
	}

}
