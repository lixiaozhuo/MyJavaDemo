package com.lixiaozhuo._20_aop_common;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;

//事务管理器
public class TransactionManager {
	public void begin() {
		System.out.println("开启事务");
	}

	public void commit() {
		System.out.println("提交事务");
	}

	public void rollback(Exception e) {
		System.out.println("回滚事务,错误类型:" + e.getMessage());
	}

	public void close() {
		System.out.println("关闭资源");
	}
	
	//环绕事务
	public Object around(ProceedingJoinPoint proceedingJoinPoint) {
		Object obj = null;
		System.out.println("环绕增强");
		try {
			System.out.println("开启事务");
			System.out.println("提交事务");
			//获取对象
			System.out.println(proceedingJoinPoint.getTarget());
			//获取方法签名
			System.out.println(proceedingJoinPoint.getSignature());
			//获取方法参数
			System.out.println(Arrays.toString(proceedingJoinPoint.getArgs()));
			//执行方法
			obj = proceedingJoinPoint.proceed();
		} catch (Throwable e) {
			System.out.println("回滚事务,错误类型:" + e.getMessage());
		} finally {
			System.out.println("关闭资源");
		}

		return obj;
	}
}
