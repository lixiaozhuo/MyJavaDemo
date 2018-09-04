package com.lixiaozhuo._20_aop_common.dao;

import com.lixiaozhuo._20_aop_common.domain.Employee;

public interface IEmployeeDAO {
	void save(Employee obj);
	
	void update(Employee obj);
}
