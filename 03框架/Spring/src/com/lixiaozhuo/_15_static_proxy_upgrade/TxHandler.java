package com.lixiaozhuo._15_static_proxy_upgrade;

import java.lang.reflect.Method;

import com.lixiaozhuo._20_aop_common.TransactionManager;
import com.lixiaozhuo._20_aop_common.service.impl.EmployeeServiceImpl;

//事务处理器
public class TxHandler implements IHandler {
	// 维护真实对象的引用
	private Object target = new EmployeeServiceImpl();
	// 维护事务对象
	private TransactionManager tm = new TransactionManager();

	@Override
	public void invoke(Method m, Object[] args) {
		System.out.println("调用的方法名为 : " + m.getName());
		try {
			// 开始事务
			tm.begin();
			// ================
			// 调用真实对象的方法
			m.invoke(target, args);
			// ================
			// 提交事务
			tm.commit();
		} catch (Exception e) {
			// 回滚事务
			tm.rollback(e);
		}
	}

}
