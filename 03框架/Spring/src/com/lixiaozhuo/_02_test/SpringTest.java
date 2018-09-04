package com.lixiaozhuo._02_test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//让spring运行在JVM上
@RunWith(SpringJUnit4ClassRunner.class)
//读取配置文件 默认=测试文件-context.xml
@ContextConfiguration("classpath:com/lixiaozhuo/_02_test/SpringTest-context.xml")
public class SpringTest {
	@Autowired
	BeanFactory factory;
	@Test
	public void test(){
		Hello hello = factory.getBean("hello",Hello.class);
		System.out.println(hello);
	}
}
