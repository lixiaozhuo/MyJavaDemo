package com.lixiaozhuo._07_many2one;

import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;

import com.lixiaozhuo.utils.HibernateUtil;

//单向多对一
public class Many2OneTest {
	@Before
	public void before() {
		Department dept = new Department();
		dept.setName("开发部 ");
		Employee em1 = new Employee();
		em1.setDept(dept);
		em1.setName("aa");
		Employee em2 = new Employee();
		em2.setDept(dept);
		em2.setName("bb");
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
		System.out.println("=================");
		Session session = HibernateUtil.getSession();
		Employee em = session.get(Employee.class, 1L);
		System.out.println(em.getName());
		//延时加载,必须在session关闭前进行加载延时对象
		Department dept = em.getDept();
		if(dept != null){
			System.out.println("不为空");
		}
		//System.out.println(dept.getClass());
		
		session.close();
		//System.out.println(dept.getName());
	}
}
