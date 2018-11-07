package com.lixiaozhuo.jedis;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * jedisClient测试
 * @author lxz
 *
 */
public class JedisClientTest {
	/**
	 * 单机与集群通用
	 * @throws Exception
	 */
	@Test
	public void testJedisClient() throws Exception {
		//初始化spring容器
		AbstractApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-redis.xml");
		//从容器中获得JedisClient对象
		JedisClient jedisClient = applicationContext.getBean(JedisClient.class);
		jedisClient.set("a", "a");
		String string = jedisClient.get("a");
		System.out.println(string);
		applicationContext.close();
	}
}
