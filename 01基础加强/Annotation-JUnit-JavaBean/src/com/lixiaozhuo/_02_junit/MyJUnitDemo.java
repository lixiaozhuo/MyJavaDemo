package com.lixiaozhuo._02_junit;

//测试自定义注解,模拟JUnit
public class MyJUnitDemo {
	@MyBefore
	public void begin() {
		System.out.println("begin");
	}

	@MyTest
	public void work() {
		System.out.println("aaa");
	}
	
	@MyAfter
	public void end() {
		System.out.println("end");
	}
}
