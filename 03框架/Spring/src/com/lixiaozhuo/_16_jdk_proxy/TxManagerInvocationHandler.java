package com.lixiaozhuo._16_jdk_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import com.lixiaozhuo._20_aop_common.TransactionManager;
import com.lixiaozhuo._20_aop_common.service.impl.EmployeeServiceImpl;

//JDK代理处理器
public class TxManagerInvocationHandler implements InvocationHandler {
	// 维护真实对象的引用
	private Object target = new EmployeeServiceImpl();
	// 维护事务对象
	private TransactionManager tm = new TransactionManager();

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println("调用的方法名为 : " + method.getName());
		Object obj = null;
		try {
			// 开始事务
			tm.begin();
			// ================
			// 调用真实对象的方法
			obj = method.invoke(target, args);
			// ================
			// 提交事务
			tm.commit();
		} catch (Exception e) {
			// 回滚事务
			tm.rollback(e);
		}
		return obj;
	}

}
