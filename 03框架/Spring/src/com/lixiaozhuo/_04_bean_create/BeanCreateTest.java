package com.lixiaozhuo._04_bean_create;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lixiaozhuo._04_bean_create.constructor.SomeBean;
import com.lixiaozhuo._04_bean_create.factorybean.SomeBean4;
import com.lixiaozhuo._04_bean_create.instancefactory.SomeBean3;
import com.lixiaozhuo._04_bean_create.staticfactory.SomeBean2;

//Bean实例化方式
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class BeanCreateTest {
	@Autowired
	private ApplicationContext context;

	// 构造器实例化（无参数构造器），最标准，使用最多。
	@Test
	public void testConstructor() throws Exception {
		// SomeBean bean = new SomeBean();
		// System.out.println(bean);
		SomeBean bean = context.getBean("someBean", SomeBean.class);
		System.out.println(bean);
	}

	// 静态工厂方法实例化：解决系统遗留问题
	@Test
	public void testStaticFactory() throws Exception {
		// SomeBean2 bean = SomeBean2Factory.getSomeBean();
		// System.out.println(bean);
		SomeBean2 bean = context.getBean("someBean2", SomeBean2.class);
		System.out.println(bean);
	}

	// 实例工厂方法实例化：解决系统遗留问题
	@Test
	public void testInstanceFactory() throws Exception {
		// SomeBean3 bean = new SomeBean3Factory().getSomeBean();
		// System.out.println(bean);
		SomeBean3 bean = context.getBean("someBean3", SomeBean3.class);
		System.out.println(bean);
	}

	// 实现FactoryBean接口实例化：实例工厂变种：集成其他框架使用：LocalSessionFactoryBean
	@Test
	public void testFactoryBean() throws Exception {
		// SomeBean4 bean = new SomeBean4Factory().getObject();
		// System.out.println(bean);
		SomeBean4 bean = context.getBean("someBean4", SomeBean4.class);
		System.out.println(bean);

	}
}
