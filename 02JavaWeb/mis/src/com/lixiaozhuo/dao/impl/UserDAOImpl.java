package com.lixiaozhuo.dao.impl;

import java.util.List;

import com.lixiaozhuo.dao.IUserDAO;
import com.lixiaozhuo.domain.User;
import com.lixiaozhuo.handle.IResultSetHandler;
import com.lixiaozhuo.handle.impl.BeanHandler;
import com.lixiaozhuo.handle.impl.BeanListHandler;
import com.lixiaozhuo.handle.impl.ScaleHandler;
import com.lixiaozhuo.utils.JDBCTemplate;

@SuppressWarnings("all")
//用户账号DAO接口实现类
public class UserDAOImpl implements IUserDAO {
	private IResultSetHandler<User> beanHandler = new BeanHandler<>(User.class);
	private IResultSetHandler<List<User>> beanListHandler = new BeanListHandler<>(
			User.class);;
	private IResultSetHandler<Long> scaleHandler = new ScaleHandler();
	
	//获取用户信息
	@Override
	public User getUserByUsername(String username) {
		String sql = "SELECT * FROM tb_user WHERE username=?";
		return JDBCTemplate.query(beanHandler, sql, username);
	}

}
