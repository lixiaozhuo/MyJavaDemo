package com.lixiaozhuo._05_session;

import org.hibernate.Session;
import org.junit.Test;

import com.lixiaozhuo.utils.HibernateUtil;

//Session主要方法
public class SessionMethodTest {
	/**
	 * update delete saveOrUpdate merge 必须存在事务环境
	 * 
	 * @throws Exception
	 */
	@Test
	public void testMethod() throws Exception {
		Person obj1 = new Person();
		obj1.setName("aaa");
		Session session1 = HibernateUtil.getSession();		
		session1.save(obj1);
		session1.close();
		
		Person obj = new Person();
		obj.setId(1L);
		obj.setName("bbb");
		Session session = HibernateUtil.getSession();
		session.beginTransaction();

		//session.update(obj);//更新

		//session.saveOrUpdate(obj); // 保存或更新
		//session.merge(obj);// 保存或更新,JPA接口

		session.delete(obj);//删除
		System.out.println("==================");
		session.getTransaction().commit();
		session.close();
	}

	/**
	 * save方法不必存在事务环境也可执行 persist必须存在事务环境
	 * 
	 * @throws Exception
	 */
	@Test
	public void testSave() throws Exception {
		Person obj = new Person();
		obj.setName("aaa");
		Session session = HibernateUtil.getSession();
		session.beginTransaction();

		session.save(obj);
		
		//session.persist(obj);//保存方法,JPA接口
		System.out.println("=======================");
		session.getTransaction().commit();
		session.close();
	}

		
}
