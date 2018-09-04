package com.lixiaozhuo._09_one2many_many2one;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;

import com.lixiaozhuo.utils.HibernateUtil;

//双向单对多
public class App {
	@Before
	public void before() {
		Department depa = new Department();
		depa.setName("研发部");
		
		Employee em1 = new Employee();
		em1.setName("aaa");
		Employee em2 = new Employee();
		em2.setName("bbb");
		
		depa.getEm().add(em1);
		depa.getEm().add(em2);
		em1.setDepa(depa);
		em2.setDepa(depa);
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		session.save(depa);
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
