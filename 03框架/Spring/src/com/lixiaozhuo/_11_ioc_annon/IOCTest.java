package com.lixiaozhuo._11_ioc_annon;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
//注解配置
public class IOCTest {
	@Autowired
	@Qualifier("someBean")
	private SomeBean someBean;
	@Autowired
	private ApplicationContext context;
	@Test
	public void test() throws Exception {
		System.out.println(someBean);
		System.out.println(context.getBean("someBean",SomeBean.class));
		System.out.println(context.getBean("someBean",SomeBean.class));
		System.out.println(context.getBean("someBean",SomeBean.class));
	}
}
