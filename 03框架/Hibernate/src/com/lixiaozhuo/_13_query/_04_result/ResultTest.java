package com.lixiaozhuo._13_query._04_result;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.junit.Test;

import com.lixiaozhuo._13_query.domain.Department;
import com.lixiaozhuo._13_query.domain.Employee;
import com.lixiaozhuo.utils.HibernateUtil;

//结果集处理
public class ResultTest {

	// 查询所有员工信息
	@Test
	public void test1() throws Exception {
		String hql = "SELECT e FROM Employee e";
		Session session = HibernateUtil.getSession();
		Query<Employee> query = session.createQuery(hql, Employee.class);
		List<Employee> list = query.list();
		for (Employee obj : list) {
			System.out.println(obj);
		}
	}

	// 查询所有员工的名称
	@Test
	public void test2() throws Exception {
		String hql = "SELECT e.name FROM Employee e";
		Session session = HibernateUtil.getSession();
		Query<String> query = session.createQuery(hql, String.class);
		List<String> list = query.list();
		for (String obj : list) {
			System.out.println(obj);
		}
	}

	// 查询所有员工的所在部门
	@Test
	public void test3() throws Exception {
		String hql = "SELECT e.dept FROM Employee e";
		Session session = HibernateUtil.getSession();
		Query<Department> query = session.createQuery(hql, Department.class);
		List<Department> list = query.list();
		for (Department obj : list) {
			System.out.println(obj);
		}
	}

	// 查询所有员工的ID,名字,工资,部门的名字
	@Test
	public void test4() throws Exception {
		String hql = "SELECT e.id,e.name,e.salary,e.dept.name FROM Employee e";
		Session session = HibernateUtil.getSession();
		Query<Object[]> query = session.createQuery(hql, Object[].class);
		List<Object[]> list = query.list();
		for (Object[] obj : list) {
			System.out.println(Arrays.toString(obj));
		}
	}
}
