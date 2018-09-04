package com.lixiaozhuo._05_session;

import java.sql.Connection;
import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.jdbc.ReturningWork;
import org.hibernate.jdbc.Work;

import com.lixiaozhuo.utils.HibernateUtil;

//Hibernate中执行JDBC
public class JDBCMethod {
	/**
	 * 执行JDBC
	 */
	void testJDBC() {
		Session session = HibernateUtil.getSession();
		session.doWork(new Work() {
			@Override
			public void execute(Connection connection) throws SQLException {
			}
		});
		session.doReturningWork(new ReturningWork<Person>() {
			@Override
			public Person execute(Connection connection) throws SQLException {
				return null;
			}
		});
	}
}
