package com.lixiaozhuo._19_aop_annon.aop_common;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
//<aop:aspect ref="txManager">
@Aspect
public class TransactionManager {
	// <aop:pointcut expression="execution(*
	// com.lixiaozhuo.aop_common.service.*Service.*(..))" id="txPointcut"/>
	@Pointcut("execution(* com.lixiaozhuo._19_aop_annon.aop_common.service.*Service.*(..))")
	public void txPointcut() {
	}

	// <aop:before method="begin" pointcut-ref="txPointcut"/>
	//@Before("txPointcut()")
	public void begin() {
		System.out.println("开启事务");
	}

	// <aop:after-returning method="commit" pointcut-ref="txPointcut"/>
	//@AfterReturning("txPointcut()")
	public void commit() {
		System.out.println("提交事务");
	}

	// <aop:after-throwing method="rollback" pointcut-ref="txPointcut"
	// throwing="e"/>
	@AfterThrowing(value="txPointcut()",throwing="e")
	public void rollback() {
		System.out.println("回滚事务");
	}

	// <aop:after method="close" pointcut-ref="txPointcut"/>
	//@After("txPointcut()")
	public void close() {
		System.out.println("关闭资源");
	}

	// <aop:around method="around" pointcut-ref="txPointcut"/>
	@Around("txPointcut()")
	public Object around(ProceedingJoinPoint proceedingJoinPoint) {
		Object obj = null;
		System.out.println("环绕增强");
		try {
			System.out.println("开启事务");
			System.out.println("提交事务");
			// 获取对象
			System.out.println(proceedingJoinPoint.getTarget());
			// 获取方法签名
			System.out.println(proceedingJoinPoint.getSignature());
			// 获取方法参数
			System.out.println(Arrays.toString(proceedingJoinPoint.getArgs()));
			// 执行方法
			obj = proceedingJoinPoint.proceed();
		} catch (Throwable e) {
			System.out.println("回滚事务,错误类型:" + e.getMessage());
		} finally {
			System.out.println("关闭资源");
		}

		return obj;
	}
}
