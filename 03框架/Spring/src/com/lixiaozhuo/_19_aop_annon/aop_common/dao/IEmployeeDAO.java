package com.lixiaozhuo._19_aop_annon.aop_common.dao;

import com.lixiaozhuo._19_aop_annon.aop_common.domain.Employee;

public interface IEmployeeDAO {
	void save(Employee obj);

	void update(Employee obj);
}
