package com.lixiaozhuo._14_static_proxy;

import org.junit.Test;

import com.lixiaozhuo._20_aop_common.domain.Employee;
import com.lixiaozhuo._20_aop_common.service.IEmployeeService;

//静态代理测试
public class StaticProxyTest {
	@Test
	public void testSave() throws Exception {
		IEmployeeService employeeService = new EmployeeServiceImplStaticProxy();
		employeeService.save(new Employee());
	}

	@Test
	public void testUpdate() throws Exception {
		IEmployeeService employeeService = new EmployeeServiceImplStaticProxy();
		employeeService.update(new Employee());
	}
}
