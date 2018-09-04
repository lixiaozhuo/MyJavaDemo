package com.lixiaozhuo._15_static_proxy_upgrade;

import java.lang.reflect.Method;

import com.lixiaozhuo._20_aop_common.service.impl.EmployeeServiceImpl;

//消耗时间处理器
public class TimeHandler implements IHandler {
	// 维护真实对象的引用
	private Object target = new EmployeeServiceImpl();

	@Override
	public void invoke(Method m, Object[] args) {
		System.out.println("调用的方法名为 : " + m.getName());

		try {
			Long beginTime = System.currentTimeMillis();
			// ================
			// 调用真实对象的方法
			m.invoke(target, args);
			// ================
			Long endTime = System.currentTimeMillis();
			System.out.println("消耗时间 = " + (endTime - beginTime));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
