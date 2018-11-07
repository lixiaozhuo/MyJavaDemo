package com.lixiaozhuo.service;

import java.util.List;

import com.lixiaozhuo.domain.Employee;
import com.lixiaozhuo.page.PageResult;
import com.lixiaozhuo.query.QueryObject;

public interface IEmployeeService {
	void save(Employee entity);
	
	void update(Employee entity);
	
	void delete(Employee entity);
	
	Employee get(Long id);
	
	List<Employee> list();
	
	PageResult<Employee> query(QueryObject qo);
	
	/**
	 * 检查账号密码是否正确
	 * @param name 账户
	 * @param password 密码
	 */
	void checkLogin(String username,String password);
}
