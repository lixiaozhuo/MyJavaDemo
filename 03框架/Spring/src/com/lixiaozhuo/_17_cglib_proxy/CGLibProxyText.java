package com.lixiaozhuo._17_cglib_proxy;

import org.junit.Test;
import org.springframework.cglib.proxy.Enhancer;

import com.lixiaozhuo._20_aop_common.domain.Employee;
import com.lixiaozhuo._20_aop_common.service.IEmployeeService;
import com.lixiaozhuo._20_aop_common.service.impl.EmployeeServiceImpl;

//CJLib 代理测试
public class CGLibProxyText {
	@Test
	public void test() throws Exception {
		Object object = null;
		Enhancer enhancer = new Enhancer();
		// 设置需要继承的类
		enhancer.setSuperclass(EmployeeServiceImpl.class);
		// 定义需要增强的内容
		enhancer.setCallback(new TxManagerInvocationHandler());
		// 创建代理对象
		object = enhancer.create();
		IEmployeeService employeeService = (IEmployeeService) object;
		employeeService.save(new Employee());
	}
}
