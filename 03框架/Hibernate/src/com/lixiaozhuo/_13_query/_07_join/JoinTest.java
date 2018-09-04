package com.lixiaozhuo._13_query._07_join;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.junit.Test;

import com.lixiaozhuo._13_query.domain.Employee;
import com.lixiaozhuo.utils.HibernateUtil;

//连接查询/聚集函数和子查询/命名查询
public class JoinTest {
	// 查询出所有员工名称及部门名称[JOIN/LEFT JOIN]
	// 在HQL中使用JOIN查询时绝不能使用ON
	@Test
	public void test1() throws Exception {
		// 隐式内连接
		// String hql = "SELECT e.name,e.dept.name FROM Employee e";
		// 显示内连接查询
		String hql = "SELECT e.name,d.name FROM Employee e JOIN e.dept d";
		Session session = HibernateUtil.getSession();
		Query<Object[]> query = session.createQuery(hql, Object[].class);
		List<Object[]> list = query.list();
		for (Object[] obj : list) {
			System.out.println(Arrays.toString(obj));
		}
	}

	// 左外连接
	@Test
	public void test2() throws Exception {
		String hql = "SELECT e.name,d.name FROM Employee e LEFT JOIN e.dept d";
		Session session = HibernateUtil.getSession();
		Query<Object[]> query = session.createQuery(hql, Object[].class);
		List<Object[]> list = query.list();
		for (Object[] obj : list) {
			System.out.println(Arrays.toString(obj));
		}
	}

	// 查询出市场部员工id,名字及电话号码
	@Test
	public void test3() throws Exception {
		String hql = "SELECT p.employee.id,p.employee.name,p.number FROM Phone p "//
				+ "WHERE p.employee.dept.name = ?1";
		Session session = HibernateUtil.getSession();
		Query<Object[]> query = session.createQuery(hql, Object[].class);
		query.setParameter(1, "市场部");
		List<Object[]> list = query.list();
		for (Object[] obj : list) {
			System.out.println(Arrays.toString(obj));
		}
	}

	// 查询出各个部门员工的平均工资和最高工资[使用聚集函数]
	@Test
	public void test4() throws Exception {
		String hql = "SELECT AVG(e.salary),MAX(e.salary) FROM Employee e GROUP BY e.dept";
		Session session = HibernateUtil.getSession();
		Query<Object[]> query = session.createQuery(hql, Object[].class);
		List<Object[]> list = query.list();
		for (Object[] obj : list) {
			System.out.println(Arrays.toString(obj));
		}
	}

	// 查询出各个项目和该项目参与人数
	@Test
	public void test5() throws Exception {
		String hql = "SELECT p.name,p.emps.size FROM Project p";
		Session session = HibernateUtil.getSession();
		Query<Object[]> query = session.createQuery(hql, Object[].class);
		List<Object[]> list = query.list();
		for (Object[] obj : list) {
			System.out.println(Arrays.toString(obj));
		}
	}

	// 查询出大于平均工资的员工信息
	@Test
	public void test6() throws Exception {
		String hql = "SELECT e FROM Employee e WHERE e.salary > (SELECT AVG(ee.salary) FROM Employee ee)";
		Session session = HibernateUtil.getSession();
		Query<Employee> query = session.createQuery(hql,Employee.class);
		List<Employee> list = query.list();
		for (Employee obj : list) {
			System.out.println(obj);
		}
	}

	// 命名查询()NamedQuery
	@Test
	@SuppressWarnings("all")
	public void test7() throws Exception {
		Session session = HibernateUtil.getSession();
		Query<Employee> query = session.getNamedQuery("test");
		List<Employee> list = query.list();
		for (Employee obj : list) {
			System.out.println(obj);
		}
	}

}
