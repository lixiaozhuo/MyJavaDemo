package com.lixiaozhuo._03_config;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

//配置测试
public class ConfigTest {
	@Test
	public void test(){

		SessionFactory bf = new Configuration().configure().buildSessionFactory();
		Session session = bf.openSession();
		session.close();
		bf.close();
	}
}
