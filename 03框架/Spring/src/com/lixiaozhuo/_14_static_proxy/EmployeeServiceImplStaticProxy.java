package com.lixiaozhuo._14_static_proxy;

import com.lixiaozhuo._20_aop_common.TransactionManager;
import com.lixiaozhuo._20_aop_common.domain.Employee;
import com.lixiaozhuo._20_aop_common.service.IEmployeeService;
import com.lixiaozhuo._20_aop_common.service.impl.EmployeeServiceImpl;

//静态代理模式
public class EmployeeServiceImplStaticProxy implements IEmployeeService {
	private IEmployeeService employeeService = new EmployeeServiceImpl();
	private TransactionManager tm = new TransactionManager();

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
