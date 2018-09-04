package com.lixiaozhuo._13_query._04_result;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.junit.Test;

import com.lixiaozhuo.utils.HibernateUtil;

//结果集封装处理
//查询所有员工的编号,名字,工资,所在部门的编号和名字
@SuppressWarnings("all")
public class ResultPakTest {
	// Object[]
	@Test
	public void test1() throws Exception {
		String hql = "SELECT e.id,e.name,e.salary,e.dept.id,e.dept.name FROM Employee e";
		Session session = HibernateUtil.getSession();
		Query<Object[]> query = session.createQuery(hql, Object[].class);
		List<Object[]> list = query.list();
		for (Object[] obj : list) {
			System.out.println(Arrays.toString(obj));
		}
	}

	// List<Object>
	@Test
	public void test2() throws Exception {
		String hql = "SELECT new List(e.id,e.name,e.salary,e.dept.id,e.dept.name)"//
				+ " FROM Employee e";
		Session session = HibernateUtil.getSession();
		Query<List<Object>> query = session.createQuery(hql);
		List<List<Object>> list = query.list();
		for (List<Object> obj : list) {
			System.out.println(obj);
		}
	}

	// Map<Integer,Object>
	@Test
	public void test3() throws Exception {
		String hql = "SELECT new Map(e.id,e.name,e.salary,e.dept.id,e.dept.name)"//
				+ " FROM Employee e";
		Session session = HibernateUtil.getSession();
		Query<Map<Integer,Object>> query = session.createQuery(hql);
		List<Map<Integer,Object>> list = query.list();
		for (Map<Integer,Object> obj : list) {
			System.out.println(obj);
		}
	}

	// Map<String,Object>
	@Test
	public void test4() throws Exception {
		String hql = "SELECT new Map(e.id AS eid,e.name AS ename,e.salary AS esalary,"//
				+ "e.dept.id AS did,e.dept.name AS dname)"//
				+ " FROM Employee e";
		Session session = HibernateUtil.getSession();
		Query<Map<String,Object>> query = session.createQuery(hql);
		List<Map<String,Object>> list = query.list();
		for (Map<String,Object> obj : list) {
			System.out.println(obj);
		}
	}

	// VO
	@Test
	public void test5() throws Exception {
		String hql = "SELECT new com.lixiaozhuo._13_query._04_result.EmployeeVO("//
				+ "e.id,e.name,e.salary,"//
				+ "e.dept.id,e.dept.name)"//
				+ " FROM Employee e";
		Session session = HibernateUtil.getSession();
		Query<EmployeeVO> query = session.createQuery(hql,EmployeeVO.class);
		List<EmployeeVO> list = query.list();
		for (EmployeeVO obj : list) {
			System.out.println(obj);
		}
	}

	// import
	@Test
	public void test6() throws Exception {
		String hql = "SELECT new EmployeeVO("//
				+ "e.id,e.name,e.salary,"//
				+ "e.dept.id,e.dept.name)"//
				+ " FROM Employee e";
		Session session = HibernateUtil.getSession();
		Query<EmployeeVO> query = session.createQuery(hql,EmployeeVO.class);
		List<EmployeeVO> list = query.list();
		for (EmployeeVO obj : list) {
			System.out.println(obj);
		}
	}
}
