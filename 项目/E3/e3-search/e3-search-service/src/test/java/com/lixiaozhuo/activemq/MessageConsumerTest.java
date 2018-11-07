package com.lixiaozhuo.activemq;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 消息队列消费者测试
 * 
 * @author lxz
 *
 */
public class MessageConsumerTest {
	@Test
	public void msgConsumer() throws Exception {
		// 初始化spring容器
		AbstractApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:spring/applicationContext-activemq.xml");
		System.out.println("开始");
		System.in.read();
		context.close();
	}
}
