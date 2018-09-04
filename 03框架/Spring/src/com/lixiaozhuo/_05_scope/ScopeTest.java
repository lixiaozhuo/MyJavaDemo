package com.lixiaozhuo._05_scope;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//bean配置
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class ScopeTest {
	@Autowired
	private ApplicationContext context;

	//作用域测试
	@Test
	public void testScope() throws Exception {
		SomeBean bean1 = context.getBean("someBean", SomeBean.class);
		SomeBean bean2 = context.getBean("someBean", SomeBean.class);
		SomeBean bean3 = context.getBean("someBean", SomeBean.class);
		System.out.println(bean1);
		System.out.println(bean2);
		System.out.println(bean3);
	}
	
	//Spring控制初始化和销毁
	@Test
	public void test() throws Exception {
		context.getBean("someBean",SomeBean.class);
	}

}
