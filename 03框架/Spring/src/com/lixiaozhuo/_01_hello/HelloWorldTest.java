package com.lixiaozhuo._01_hello;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

@SuppressWarnings("all")
public class HelloWorldTest {
	@Test
	public void testOld() throws Exception {
		HelloWorld hello = new HelloWorld();
		hello.setValue("value");
		hello.sayHello();
	}
	
	@Test
	public void testSpring() throws Exception {
		//创建spring容器
		Resource resource = new ClassPathResource("applicationContext.xml");
		BeanFactory factory = new XmlBeanFactory(resource );		
		//取出对象
		//方式1,通过bean名字
		HelloWorld hello = (HelloWorld) factory.getBean("helloworld");
		hello.sayHello();
		//方式2,通过类型
		hello = factory.getBean(HelloWorld.class);
		hello.sayHello();
		//方式3,通过名字+类型
		factory.getBean("helloworld", HelloWorld.class);
		hello.sayHello();
	}
}
