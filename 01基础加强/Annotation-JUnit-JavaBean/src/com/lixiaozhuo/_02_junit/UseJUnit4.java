package com.lixiaozhuo._02_junit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

//JUnit4测试
@SuppressWarnings("all")
public class UseJUnit4 {
	@Before
	public void begin() {
		System.out.println("begin");
	}

	@Test
	public void work() {
		System.out.println("workaaa");
	}
	@After
	public void end() {
		System.out.println("end");
	}
	@Test
	public void testName() throws Exception {
		System.out.println("testName");
		Assert.assertFalse(false);
		System.out.println("mmm");
	}
}
