package com.lixiaozhuo._13_query._06_collection;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.junit.Test;

import com.lixiaozhuo._13_query.domain.Project;
import com.lixiaozhuo.utils.HibernateUtil;

//hql集合操作
public class CollectionTest {
	// 1.查询有员工参与开发的项目
	@Test
	public void test1() throws Exception {
		// String hql = "SELECT p FROM Project p WHERE p.emps.size > 0";
		String hql = "SELECT p FROM Project p WHERE size(p.emps) > 0";
		Session session = HibernateUtil.getSession();
		Query<Project> query = session.createQuery(hql, Project.class);
		List<Project> list = query.list();
		for (Project obj : list) {
			System.out.println(obj);
		}
	}

	// 2.查询出没有员工参与的项目【对集合使用size/is empty】
	@Test
	public void test2() throws Exception {
		// String hql = "SELECT p FROM Project p WHERE size(p.emps) = 0";
		String hql = "SELECT p FROM Project p WHERE p.emps is empty";
		Session session = HibernateUtil.getSession();
		Query<Project> query = session.createQuery(hql, Project.class);
		List<Project> list = query.list();
		for (Project obj : list) {
			System.out.println(obj);
		}
	}

	// 3.查询出项目信息，按照项目的参与者总数排序【使用函数排序】
	@Test
	public void test3() throws Exception {
		// String hql = "SELECT p FROM Project p WHERE size(p.emps) = 0";
		String hql = "SELECT p FROM Project p ORDER BY p.emps.size";
		Session session = HibernateUtil.getSession();
		Query<Project> query = session.createQuery(hql, Project.class);
		List<Project> list = query.list();
		for (Project obj : list) {
			System.out.println(obj);
		}
	}
}
