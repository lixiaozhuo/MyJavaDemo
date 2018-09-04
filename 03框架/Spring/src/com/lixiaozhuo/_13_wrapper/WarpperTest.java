package com.lixiaozhuo._13_wrapper;

import org.junit.Test;

import com.lixiaozhuo._20_aop_common.TransactionManager;
import com.lixiaozhuo._20_aop_common.domain.Employee;
import com.lixiaozhuo._20_aop_common.service.IEmployeeService;
import com.lixiaozhuo._20_aop_common.service.impl.EmployeeServiceImpl;

//装饰者模式测试
public class WarpperTest {
	@Test
	public void testSave() throws Exception {
		IEmployeeService employeeService = new EmployeeServiceImplWarpper(
				new EmployeeServiceImpl(), new TransactionManager());
		employeeService.save(new Employee());
	}

	@Test
	public void testUpdate() throws Exception {
		IEmployeeService employeeService = new EmployeeServiceImplWarpper(
				new EmployeeServiceImpl(), new TransactionManager());
		employeeService.update(new Employee());
	}
}
