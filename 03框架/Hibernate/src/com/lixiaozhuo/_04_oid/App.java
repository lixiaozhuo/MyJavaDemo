package com.lixiaozhuo._04_oid;

import org.hibernate.Session;
import org.junit.Test;

import com.lixiaozhuo.utils.HibernateUtil;

//主键生成策略测试
public class App {

	@Test
	public void test() throws Exception {
		Person obj = new Person();
		obj.setId(1L);
		obj.setName("aaa");
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		session.save(obj);
		session.getTransaction().commit();
		session.close();
	}

}
