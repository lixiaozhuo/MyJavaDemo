package com.lixiaozhuo.service;

import java.util.List;

import com.lixiaozhuo.domain.Employee;
import com.lixiaozhuo.page.PageResult;
import com.lixiaozhuo.query.QueryObject;

//service接口
public interface IEmployeeService {
	/**
	 * 保存信息
	 * 
	 * @param obj
	 *            要保存的信息
	 */
	void save(Employee obj);

	/**
	 * 更新信息
	 * 
	 * @param obj
	 *            要更新的信息
	 */
	void update(Employee obj);

	/**
	 * 删除指定id信息
	 * 
	 * @param id
	 *            要删除信息的id
	 */
	void delete(Long id);

	/**
	 * 得到指定id信息
	 * 
	 * @param id
	 *            要查询的信息id
	 * @return 查询的信息
	 */
	Employee get(Long id);

	/**
	 * 获取所有信息
	 * @return 所有信息
	 */
	List<Employee> list();
	
	/**
	 * 高级查询
	 * @param objs 查询条件
	 * @return 信息集
	 */
	PageResult query(QueryObject qo);
	
	/**
	 * 获取用户名密码对应用户
	 * @param username 用户名
	 * @param password 密码
	 * @return 用户名密码对应用户
	 */
	Employee checkLogin(String username, String password);
	
}
