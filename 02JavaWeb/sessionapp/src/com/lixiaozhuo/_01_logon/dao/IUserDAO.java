package com.lixiaozhuo._01_logon.dao;

import com.lixiaozhuo._01_logon.domain.User;

public interface IUserDAO {

	/**
	 * 获取user对象
	 * 
	 * @param username
	 *            用户名
	 * @return user对象
	 */
	public User getUserByUsername(String username);
}
