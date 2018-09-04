package com.lixiaozhuo._10_di_annon.javaee_tag;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//自动装配注解方式:JavaEE中的标签
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class JavaEETest {

	@Resource
	private SomeBean someBean;

	@Test
	public void test() throws Exception {
		System.out.println(someBean);
	}
}
