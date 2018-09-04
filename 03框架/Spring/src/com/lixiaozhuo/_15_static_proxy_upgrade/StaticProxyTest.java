package com.lixiaozhuo._15_static_proxy_upgrade;

import org.junit.Test;

import com.lixiaozhuo._20_aop_common.domain.Employee;
import com.lixiaozhuo._20_aop_common.service.IEmployeeService;

//静态代理加强测试
public class StaticProxyTest {
	@Test
	public void test() throws Exception {
		IEmployeeService employeeService = new EmployeeServiceImplStaticProxy(
				new TimeHandler());
		employeeService.save(new Employee());
	}
}
