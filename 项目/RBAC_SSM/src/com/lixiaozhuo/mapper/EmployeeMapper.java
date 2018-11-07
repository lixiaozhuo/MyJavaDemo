package com.lixiaozhuo.mapper;

import org.apache.ibatis.annotations.Param;

import com.lixiaozhuo.domain.Employee;

public interface EmployeeMapper extends IGernericMapper<Employee> {
	/**
	 * 通过账户密码得到用户对象
	 * 
	 * @param name
	 *            账户
	 * @param password
	 *            密码
	 * @return 用户
	 */
	Employee getUserByNameAndPassword(@Param("name") String name,
			@Param("password") String password);

	void insertRelation(@Param("empId") Long empId,
			@Param("roleId") Long roleId);

	void deleteRelation(@Param("empId") Long empId,
			@Param("roleId") Long roleId);
}
