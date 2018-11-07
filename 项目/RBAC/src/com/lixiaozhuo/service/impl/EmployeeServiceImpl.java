package com.lixiaozhuo.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.lixiaozhuo.dao.IEmployeeDAO;
import com.lixiaozhuo.domain.Employee;
import com.lixiaozhuo.domain.Permission;
import com.lixiaozhuo.domain.Role;
import com.lixiaozhuo.page.PageResult;
import com.lixiaozhuo.query.QueryObject;
import com.lixiaozhuo.service.IEmployeeService;
import com.lixiaozhuo.utils.UserContext;
import com.opensymphony.xwork2.ActionContext;

import lombok.Setter;

public class EmployeeServiceImpl implements IEmployeeService {
	@Setter
	IEmployeeDAO employeeDAO;

	@Override
	public void save(Employee entity) {
		employeeDAO.save(entity);
	}

	@Override
	public void update(Employee entity) {
		employeeDAO.update(entity);
	}

	@Override
	public void delete(Employee entity) {
		employeeDAO.delete(entity);
	}

	@Override
	public Employee get(Long id) {
		return employeeDAO.get(id);
	}

	@Override
	public List<Employee> list() {
		return employeeDAO.list();
	}

	@Override
	public PageResult<Employee> query(QueryObject qo) {
		return employeeDAO.query(qo);
	}

	@Override
	public void checkLogin(String username, String password) {
		Employee currentUser = employeeDAO.getUserByNameAndPassword(username,
				password);
		if (currentUser == null) {
			throw new RuntimeException("账号/密码错误");
		}
		// 将当前登录用户放入context中
		ActionContext.getContext().getSession().put(UserContext.USERINSESSION,
				currentUser);
		// 查询出当前用户拥有的权限,并将权限放入context中
		Set<String> permissionSet = new HashSet<>();
		List<Role> roles = currentUser.getRoles();
		for (Role role : roles) {
			List<Permission> permissions = role.getPermissions();
			for (Permission permission : permissions) {
				permissionSet.add(permission.getExpression());
			}
		}
		ActionContext.getContext().getSession().put(UserContext.PERMISSIONINSESSION,
				permissionSet);
	}

}
