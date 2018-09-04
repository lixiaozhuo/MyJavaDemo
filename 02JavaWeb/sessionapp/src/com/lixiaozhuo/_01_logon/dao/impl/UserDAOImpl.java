package com.lixiaozhuo._01_logon.dao.impl;

import java.util.List;

import com.lixiaozhuo._01_logon.dao.IUserDAO;
import com.lixiaozhuo._01_logon.domain.User;
import com.lixiaozhuo._01_logon.handler.IResultSetHandler;
import com.lixiaozhuo._01_logon.handler.impl.BeanHandler;
import com.lixiaozhuo._01_logon.handler.impl.BeanListHandler;
import com.lixiaozhuo._01_logon.handler.impl.ScaleHandler;
import com.lixiaozhuo._01_logon.template.jdbcTemplate;

@SuppressWarnings("all")
public class UserDAOImpl implements IUserDAO {
	private IResultSetHandler<User> beanHandler = new BeanHandler<>(User.class);
	private IResultSetHandler<List<User>> beanListHandler = new BeanListHandler<>(
			User.class);;
	private IResultSetHandler<Long> scaleHandler = new ScaleHandler();

	@Override
	public User getUserByUsername(String username) {
		String sql = "SELECT * FROM tb_user WHERE username=?";
		return jdbcTemplate.query(sql, beanHandler, username);
	}

}
