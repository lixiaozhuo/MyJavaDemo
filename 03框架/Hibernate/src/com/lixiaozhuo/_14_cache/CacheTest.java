package com.lixiaozhuo._14_cache;

import org.hibernate.Session;
import org.junit.Test;

import com.lixiaozhuo._13_query.domain.Employee;
import com.lixiaozhuo.utils.HibernateUtil;

//cache测试
public class CacheTest {
	@Test
	public void test() throws Exception{
		Session session = HibernateUtil.getSession();
		session.get(Employee.class, 1L);
		session.close();
		Thread.sleep(3000);
		Session session1 = HibernateUtil.getSession();
		session1.get(Employee.class, 1L);
		session1.close();
	}
}
