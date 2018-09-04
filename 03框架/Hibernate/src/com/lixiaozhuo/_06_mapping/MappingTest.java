package com.lixiaozhuo._06_mapping;

import org.hibernate.Session;
import org.junit.Test;

import com.lixiaozhuo.utils.HibernateUtil;

//映射配置
public class MappingTest {
	@Test
	public void test() {
		Person obj = new Person();
		obj.setName("aa");
		obj.getEmailSet().add("set1@");
		obj.getEmailSet().add("set2@");
		obj.getEmailSet().add("set1@");
		obj.getEmailList().add("list1@");
		obj.getEmailList().add("list2@");
		obj.getEmailList().add("list1@");
		obj.getEmailBag().add("bag1@");
		obj.getEmailBag().add("bag2@");
		obj.getEmailBag().add("bag1@");

		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		session.save(obj);

		session.getTransaction().commit();
		session.close();

	}
}
