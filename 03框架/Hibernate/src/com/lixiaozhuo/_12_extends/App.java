package com.lixiaozhuo._12_extends;

import java.math.BigDecimal;

import org.hibernate.Session;
import org.junit.Test;

import com.lixiaozhuo.utils.HibernateUtil;

//继承关系
public class App {
	@Test
	public void testSave() {
		User user = new User();
		user.setName("user");
		
		Employee employee = new Employee();
		employee.setName("employee");
		employee.setSalary(new BigDecimal("10"));
		
		Customer customer = new Customer();
		customer.setName("customer");
		customer.setAddress("aaa");
		
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		
		session.save(user);
		session.save(employee);
		session.save(customer);
		
		session.getTransaction().commit();
		session.close();
	}
	
	@Test
	public void test(){
		
	}
}
