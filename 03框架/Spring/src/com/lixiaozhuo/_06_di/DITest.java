package com.lixiaozhuo._06_di;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lixiaozhuo._06_di.collection.CollectionBean;
import com.lixiaozhuo._06_di.ref.SomeBean;
import com.lixiaozhuo._06_di.simple.Employee;

//依赖注入
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class DITest {
	@Autowired
	private ApplicationContext context;

	// 普通属性
	@Test
	public void testSimple() throws Exception {
		Employee bean = context.getBean("employee",Employee.class);
		System.out.println(bean);
	}

	// 引用属性
	@Test
	public void testRef() throws Exception {
		SomeBean bean = context.getBean("someBean",SomeBean.class);
		System.out.println(bean);
	}

	// 集合属性
	@Test
	public void testCollection() throws Exception {
		CollectionBean bean = context.getBean("collection",CollectionBean.class);
		System.out.println(bean);
	}
}
