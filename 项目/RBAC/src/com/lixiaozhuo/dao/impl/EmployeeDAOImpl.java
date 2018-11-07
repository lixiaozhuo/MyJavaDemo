package com.lixiaozhuo.dao.impl;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.lixiaozhuo.dao.IEmployeeDAO;
import com.lixiaozhuo.domain.Employee;

public class EmployeeDAOImpl extends GernericDAOImpl<Employee>
		implements IEmployeeDAO {

	@Override
	public Employee getUserByNameAndPassword(String username,String password) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "SELECT obj FROM Employee obj WHERE obj.name=?0 AND obj.password=?1";
		Query<Employee> query = session.createQuery(hql,Employee.class);
		query.setParameter(0, username);
		query.setParameter(1, password);
		return query.uniqueResult();
	}


}
