package com.lixiaozhuo.dao;

import com.lixiaozhuo.domain.User;

//用户信息DAO接口
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
