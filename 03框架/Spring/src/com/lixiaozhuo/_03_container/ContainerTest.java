package com.lixiaozhuo._03_container;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

//容器测试
@SuppressWarnings("all")
public class ContainerTest {

	@Test
	public void testBeanFactory() throws Exception {
		Resource resource = new ClassPathResource(
				"com/lixiaozhuo/_03_container/ContainerTest-context.xml");
		BeanFactory factory = new XmlBeanFactory(resource);
		factory.getBean("somebean", SomeBean.class);
	}

	// 默认加载所有文件
	@Test
	public void testApplicationContext() throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"com/lixiaozhuo/_03_container/ContainerTest-context.xml");
		context.getBean("somebean", SomeBean.class);
	}
}
