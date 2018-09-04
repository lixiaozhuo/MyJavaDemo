package com.lixiaozhuo._02_api;

import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.junit.Test;

//Configuration对象
public class ConfigurationTest {
	
	//Hibernate4.X获取SessionFactory
	@Test
	public void test() throws Exception {
		ServiceRegistry st = new StandardServiceRegistryBuilder().build();
		new Configuration().configure().buildSessionFactory(st);
	}
}
