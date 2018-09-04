package com.lixiaozhou.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.lixiaozhou.dao.IEmployeeDAO;
import com.lixiaozhou.domain.Employee;

import lombok.Setter;

public class EmployeeDAOImpl implements IEmployeeDAO {
	@Setter
	private SessionFactory sessionFactory;

	@Override
	public void save(Employee obj) {
		Session session = sessionFactory.getCurrentSession();
		session.save(obj);
	}

	@Override
	public void update(Employee obj) {
		Session session = sessionFactory.getCurrentSession();
		session.update(obj);
	}

	@Override
	public void delete(Employee obj) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(obj);
	}

	@Override
	public Employee get(Long id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Employee.class, id);
	}

	@Override
	public List<Employee> list() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("SELECT e FROM Employee e",Employee.class).list();
	}

}
