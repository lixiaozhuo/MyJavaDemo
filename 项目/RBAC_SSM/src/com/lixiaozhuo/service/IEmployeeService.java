package com.lixiaozhuo.service;

import java.util.List;
import java.util.Set;

import com.lixiaozhuo.domain.Employee;
import com.lixiaozhuo.page.PageResult;
import com.lixiaozhuo.query.QueryObject;

public interface IEmployeeService {
	void save(Employee entity);
	
	void save(Employee entity,String[] ids);
	
	void update(Employee entity);
	
	void update(Employee entity,String[] ids);
	
	void delete(Long id);
	
	Employee get(Long id);
	
	List<Employee> list();
	
	PageResult<Employee> query(QueryObject qo);
	
	/**
	 * 检查账号密码是否正确
	 * @param name 账户
	 * @param password 密码
	 */
	Employee checkLogin(String username,String password);
	
	Set<String> getPermission(Employee obj);
}
