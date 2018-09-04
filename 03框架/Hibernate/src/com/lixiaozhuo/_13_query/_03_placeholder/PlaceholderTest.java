package com.lixiaozhuo._13_query._03_placeholder;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.junit.Test;

import com.lixiaozhuo._13_query.domain.Employee;
import com.lixiaozhuo.utils.HibernateUtil;

//占位符测试
public class PlaceholderTest {

	// 查询工资大于5000的员工
	@Test
	public void test1() throws Exception {
		// 位置占位符
		String hql = "SELECT e FROM Employee e WHERE e.salary >= ?1";
		Session session = HibernateUtil.getSession();
		Query<Employee> query = session.createQuery(hql, Employee.class);
		query.setParameter(1, new BigDecimal("5000"));
		List<Employee> list = query.list();
		session.close();
		for (Employee obj : list) {
			System.out.println(obj);
		}
	}

	@Test
	public void test2() throws Exception {
		// 名称占位符
		String hql = "SELECT e FROM Employee e WHERE e.salary >=:sal";
		Session session = HibernateUtil.getSession();
		Query<Employee> query = session.createQuery(hql, Employee.class);
		query.setParameter("sal", new BigDecimal("5000"));
		List<Employee> list = query.list();
		session.close();
		for (Employee obj : list) {
			System.out.println(obj);
		}
	}

	// 查询id为3,5,7的员工信息
	@Test
	public void test3() throws Exception {
		//名称占位符
		String hql = "SELECT e FROM Employee e WHERE id in(:ids)";
		Session session = HibernateUtil.getSession();
		Query<Employee> query = session.createQuery(hql, Employee.class);
		query.setParameterList("ids", new Long[] { 3L, 5L, 7L });
		List<Employee> list = query.list();
		session.close();
		for (Employee obj : list) {
			System.out.println(obj);
		}
	}

}
