package com.lixiaozhuo._13_wrapper;

import com.lixiaozhuo._20_aop_common.TransactionManager;
import com.lixiaozhuo._20_aop_common.domain.Employee;
import com.lixiaozhuo._20_aop_common.service.IEmployeeService;

//装饰者模式
public class EmployeeServiceImplWarpper implements IEmployeeService {
	private IEmployeeService employeeService;
	private TransactionManager tm;

	public EmployeeServiceImplWarpper(IEmployeeService employeeService,
			TransactionManager tm) {
		this.employeeService = employeeService;
		this.tm = tm;
	}

	public void save(Employee obj) {
		try {
			tm.begin();
			// ================
			employeeService.save(obj);
			// ================
			tm.commit();
		} catch (Exception e) {
			tm.rollback(e);
		}
	}

	public void update(Employee obj) {
		try {
			tm.begin();
			// ================
			employeeService.update(obj);
			// ================
			tm.commit();
		} catch (Exception e) {
			tm.rollback(e);
		}
	}
}
