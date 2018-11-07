package com.lixiaozhuo.start;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 启动spring容器
 * 
 * @author lxz
 *
 */
public class Content {
	@Test
	public void start() throws Exception {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:spring/applicationContext-*.xml");
		System.out.println("===服务启动===");
		// 等待读取
		System.in.read();
		System.out.println("===服务结束===");
		context.close();
	}
}
