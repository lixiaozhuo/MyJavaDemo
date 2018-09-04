package com.lixiaozhuo._13_query._02_page;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.junit.Test;

import com.lixiaozhuo._13_query.domain.Employee;
import com.lixiaozhuo.utils.HibernateUtil;

//分页测试
public class LimitPageTest {
	// 查询页面结果总数
	@Test
	public void testTotalCount() {
		String hql = "SELECT COUNT(e) FROM Employee e";
		Session session = HibernateUtil.getSession();
		// 返回唯一一条数据
		Long totalCount = (Long) session.createQuery(hql).uniqueResult();
		session.close();
		System.out.println(totalCount);
	}

	// 查询结果集
	@Test
	public void testResultSet() throws Exception {
		int currentPage = 2;
		int pageSize = 10;
		String hql = "SELECT e FROM Employee e";
		Session session = HibernateUtil.getSession();
		Query<Employee> query = session.createQuery(hql, Employee.class);
		// 分页查询
		query.setFirstResult((currentPage - 1) * pageSize);
		query.setMaxResults(pageSize);
		// 执行查询
		List<Employee> list = query.list();
		for (Employee employee : list) {
			System.out.println(employee);
		}
	}
}
