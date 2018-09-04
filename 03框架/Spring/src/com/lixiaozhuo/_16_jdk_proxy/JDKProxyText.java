package com.lixiaozhuo._16_jdk_proxy;

import java.lang.reflect.Proxy;

import org.junit.Test;

import com.lixiaozhuo._20_aop_common.domain.Employee;
import com.lixiaozhuo._20_aop_common.service.IEmployeeService;
import com.lixiaozhuo._20_aop_common.service.impl.EmployeeServiceImpl;

//JDK 代理测试
public class JDKProxyText {
	@Test
	public void test() throws Exception {
		// 新建代理类
		Object object = Proxy.newProxyInstance(
				EmployeeServiceImpl.class.getClassLoader(), // 类加载器
				new Class[] { IEmployeeService.class }, // 真实对象接口
				new TxManagerInvocationHandler());// InvocationHandler对象,处理事务日志
		System.out.println(object.getClass());
		System.out.println("================");
		ProxyUtils.saveProxyClass("c:/file/a.class",object.getClass().getName(),object.getClass().
				 getInterfaces());
		System.out.println("================");
		IEmployeeService employeeService = (IEmployeeService) object;
		employeeService.save(new Employee());
	}
}
