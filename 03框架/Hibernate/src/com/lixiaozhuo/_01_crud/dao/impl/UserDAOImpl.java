package com.lixiaozhuo._01_crud.dao.impl;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.lixiaozhuo._01_crud.dao.IUserDAO;
import com.lixiaozhuo._01_crud.domain.User;
import com.lixiaozhuo.utils.HibernateUtil;

public class UserDAOImpl implements IUserDAO {

	@Override
	public void save(User obj) {
		// 创建Session对象
		Session session = HibernateUtil.getSession();
		// 具体操作
		session.beginTransaction();// 设置事务活动状态
		session.save(obj);
		session.getTransaction().commit();// 提交事务
		// 关闭Session对象
		session.close();
	}

	@Override
	public void update(User obj) {
		// 创建Session对象
		Session session = HibernateUtil.getSession();
		// 具体操作
		session.beginTransaction();// 设置事务活动状态
		session.update(obj);
		session.getTransaction().commit();// 提交事务
		// 关闭Session对象
		session.close();
	}

	@Override
	public void delete(User obj) {
		// 创建Session对象
		Session session = HibernateUtil.getSession();
		// 具体操作
		session.beginTransaction();// 设置事务活动状态
		session.delete(obj);
		session.getTransaction().commit();// 提交事务
		// 关闭Session对象
		session.close();
	}

	@Override
	public User get(Long id) {
		// 创建Session对象
		Session session = HibernateUtil.getSession();
		// 具体操作
		User user = (User) session.get(User.class, id);
		// 关闭Session对象
		session.close();
		return user;
	}

	@Override
	public List<User> listAll() {
		// 创建Session对象
		Session session = HibernateUtil.getSession();
		// 具体操作
		String hql = "SELECT u FROM User u";
		// 创建查询对象
		Query<User> query = session.createQuery(hql,User.class);
		// 执行查询
		List<User> list = query.list();
		// 关闭Session对象
		session.close();
		return list;
	}

}
