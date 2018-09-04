package com.lixiaozhuo._15_static_proxy_upgrade;

import java.lang.reflect.Method;

import com.lixiaozhuo._20_aop_common.domain.Employee;
import com.lixiaozhuo._20_aop_common.service.IEmployeeService;

//静态代理升级版
public class EmployeeServiceImplStaticProxy implements IEmployeeService {
	private IHandler h;

	public EmployeeServiceImplStaticProxy(IHandler h) {
		this.h = h;
	}

	public void save(Employee obj) {
		// 所有业务逻辑交给IHandler处理(包括增强+真实对象方法的引用)
		Method m = null;
		try {
			// 获取到接口的字节码
			Class<?> clazz = Class.forName(
					"com.lixiaozhuo.aop_common.service.IEmployeeService");
			// 获取接口上的save方法
			m = clazz.getDeclaredMethod("save", Employee.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		h.invoke(m, new Object[] { obj });
	}

	public void update(Employee obj) {
		// 所有业务逻辑交给IHandler处理(包括增强+真实对象方法的引用)
		Method m = null;
		try {
			// 获取到接口的字节码
			Class<?> clazz = Class.forName(
					"com.lixiaozhuo.aop_common.service.IEmployeeService");
			// 获取接口上的update方法
			m = clazz.getDeclaredMethod("update", Employee.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		h.invoke(m, new Object[] { obj });
	}
}
