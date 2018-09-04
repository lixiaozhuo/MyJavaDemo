package com.lixiaozhuo._13_query._01_hello;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.junit.Test;

import com.lixiaozhuo._13_query.domain.Employee;
import com.lixiaozhuo.utils.HibernateUtil;

//Hibernate查询三种方式
//查询员工名字中包含a,且id在1~10之间的
public class HelloTest {
	@Test
	@SuppressWarnings("all")
	public void testSQL() throws Exception {
		String sql = "SELECT * FROM employee WHERE name LIKE ? AND id BETWEEN ? AND ?";
		Session session = HibernateUtil.getSession();
		//创建SQL的查询对象
		Query query = session.createSQLQuery(sql);
		//设置占位符参数
		query.setParameter(1, "%a%");
		query.setParameter(2,"1");
		query.setParameter(3,"10");
		//执行查询
		List<Object[]> list = query.list();
		session.close();
		for (Object[] objs : list) {
			System.out.println(Arrays.toString(objs));
		}
	}
	
	@Test
	public void testHQL() throws Exception {
		String hql = "SELECT e FROM Employee e WHERE e.name LIKE ?1 AND e.id BETWEEN ?2 AND ?3 ";
		Session session = HibernateUtil.getSession();
		//创建查询对象
		Query<Employee> query = session.createQuery(hql,Employee.class);
		//设置占位符
		query.setParameter(1, "%a%");
		query.setParameter(2, 1L);
		query.setParameter(3,10L);
		//执行查询
		List<Employee> list = query.list();
		for (Employee e : list) {
			System.out.println(e);
		}
	}
	
	@Test
	@SuppressWarnings("all")
	public void testCriteria() throws Exception {
		Session session = HibernateUtil.getSession();
		//创建查询对象
		Criteria criteria = session.createCriteria(Employee.class);
		//设置查询条件
		criteria.add(Restrictions.like("name", "a",MatchMode.ANYWHERE));
		criteria.add(Restrictions.between("id", 1L, 10L));
		//执行查询操作
		List<Employee> list = criteria.list();
		session.close();
		for (Employee employee : list) {
			System.out.println(employee);
		}
	}
	
}
