package com.lixiaozhuo._11_many2many;

import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;

import com.lixiaozhuo.utils.HibernateUtil;

//多对多
public class App {
	@Before
	public void before() {
		Student stu1 = new Student();
		stu1.setName("aaa");
		Student stu2 = new Student();
		stu2.setName("bbb");
		Teacher tea1 = new Teacher();
		tea1.setName("111");
		Teacher tea2 = new Teacher();
		tea2.setName("222");
		
		tea1.getStudent().add(stu1);
		tea1.getStudent().add(stu2);
		
		tea2.getStudent().add(stu1);
		tea2.getStudent().add(stu2);
		
		stu1.getTeacher().add(tea1);
		stu1.getTeacher().add(tea2);
		stu2.getTeacher().add(tea1);
		stu2.getTeacher().add(tea2);
		
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		
		session.save(tea1);
		session.save(tea2);
		session.save(stu1);
		session.save(stu2);
		
		session.getTransaction().commit();
		session.close();
	}
	
	@Test
	public void test(){
		
	}
}
