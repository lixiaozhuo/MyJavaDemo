package com.lixiaozhuo.dao;

import com.lixiaozhuo.domain.Employee;

public interface IEmployeeDAO extends IGernericDAO<Employee>{
	/**
	 * 通过账户密码得到用户对象
	 * @param name 账户
	 * @param password 密码
	 * @return 用户
	 */
	Employee getUserByNameAndPassword(String username,String password);
}
