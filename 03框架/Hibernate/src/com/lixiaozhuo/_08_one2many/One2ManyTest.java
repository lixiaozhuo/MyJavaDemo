package com.lixiaozhuo._08_one2many;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;

import com.lixiaozhuo.utils.HibernateUtil;

//单向一对多
public class One2ManyTest {
	@Before
	public void before() {
		Department dept = new Department();
		dept.setName("研发部");
		
		Employee em1 = new Employee();
		em1.setName("aaa");
		Employee em2 = new Employee();
		em2.setName("bbb");
		
		dept.getEm().add(em1);
		dept.getEm().add(em2);
		
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		session.save(dept);
		session.save(em1);
		session.save(em2);
		session.getTransaction().commit();
		session.close();
	}
	
	@Test
	public void test(){
		Session session = HibernateUtil.getSession();
		Department depa = session.get(Department.class, 1L);
		Hibernate.initialize(depa.getEm());//初始化many对象
		if(depa.getEm().size() != 0){
			System.out.println("非空");
		}
		System.out.println(depa.getEm().getClass());
		
		session.close();
		
	}
}
