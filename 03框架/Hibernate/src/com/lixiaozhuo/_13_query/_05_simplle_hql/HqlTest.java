package com.lixiaozhuo._13_query._05_simplle_hql;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.junit.Test;

import com.lixiaozhuo._13_query.domain.Department;
import com.lixiaozhuo._13_query.domain.Employee;
import com.lixiaozhuo.utils.HibernateUtil;

//Hql查询联系
public class HqlTest {

	// 查询出所有员工信息，按照月薪排序【查询排序】
	@Test
	public void test1() throws Exception {
		String hql = "SELECT e FROM Employee e ORDER BY e.salary";
		Session session = HibernateUtil.getSession();
		Query<Employee> query = session.createQuery(hql,Employee.class);
		List<Employee> list = query.list();
		for (Employee obj : list) {
			System.out.println(obj);
		}
	}

	//查询出所有员工信息，按照部门编号排序【使用关联对象属性排序】
	@Test
	public void test2() throws Exception {
		String hql = "SELECT e FROM Employee e ORDER BY e.dept.sn";
		Session session = HibernateUtil.getSession();
		Query<Employee> query = session.createQuery(hql,Employee.class);
		List<Employee> list = query.list();
		for (Employee obj : list) {
			System.out.println(obj);
		}
	}
	//查询出有员工的部门【使用DISTINCT】
	@Test
	public void test3() throws Exception {
		String hql = "SELECT DISTINCT e.dept FROM Employee e";
		Session session = HibernateUtil.getSession();
		Query<Department> query = session.createQuery(hql,Department.class);
		List<Department> list = query.list();
		for (Department obj : list) {
			System.out.println(obj);
		}
	}
}
