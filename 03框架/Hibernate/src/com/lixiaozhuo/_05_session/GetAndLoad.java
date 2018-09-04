package com.lixiaozhuo._05_session;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.junit.Test;

import com.lixiaozhuo.utils.HibernateUtil;

//get和load方法对比
public class GetAndLoad {
	/**
	 * get方法
	 */
	@Test
	public void testGet() {
		Session session = HibernateUtil.getSession();

		Person p = session.get(Person.class, 1L);

		System.out.println("==============");
		System.out.println(p);

		session.close();
	}

	/**
	 * Set方法
	 */
	@Test
	public void testLoad() {
		Session session = HibernateUtil.getSession();

		Person p = session.load(Person.class, 1L);
		System.out.println("==============");
		// System.out.println(p);
		Hibernate.initialize(p);// 初始化代理对象
		session.close();

		System.out.println(p);
	}
}
