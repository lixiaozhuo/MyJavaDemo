package com.lixiaozhuo.service.impl;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lixiaozhuo.domain.Employee;
import com.lixiaozhuo.domain.Permission;
import com.lixiaozhuo.domain.Role;
import com.lixiaozhuo.mapper.EmployeeMapper;
import com.lixiaozhuo.page.PageResult;
import com.lixiaozhuo.query.QueryObject;
import com.lixiaozhuo.service.IEmployeeService;
import com.lixiaozhuo.service.IRoleService;

import lombok.Setter;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
	@Setter
	@Autowired
	EmployeeMapper mapper;
	
	@Autowired
	IRoleService roleService;

	@Override
	public void save(Employee entity) {
		mapper.save(entity);
		// 处理关系
		for (Role r : entity.getRoles()) {
			mapper.insertRelation(entity.getId(), r.getId());
		}
	}
	
	@Override
	public void save(Employee entity,String[] ids) {
		mapper.save(entity);
		if(ids == null){
			return;
		}
		// 处理关系
		for (String r : ids) {
			mapper.insertRelation(entity.getId(), Long.valueOf(r));
		}
	}

	@Override
	public void update(Employee entity) {
		// 删除对应关系
		mapper.deleteRelation(entity.getId(),null);
		mapper.update(entity);
		// 处理关系
		for (Role r : entity.getRoles()) {
			mapper.insertRelation(entity.getId(), r.getId());
		}
	}
	
	@Override
	public void update(Employee entity,String[] ids) {
		// 删除对应关系
		mapper.deleteRelation(entity.getId(),null);
		mapper.update(entity);
		if(ids == null){
			return;
		}
		// 处理关系
		for (String r : ids) {
			mapper.insertRelation(entity.getId(), Long.valueOf(r));
		}
	}

	@Override
	public void delete(Long id) {
		// 删除对应关系
		mapper.deleteRelation( id,null);
		mapper.delete(id);
	}

	@Override
	public Employee get(Long id) {
		return mapper.get(id);
	}

	@Override
	public List<Employee> list() {
		return mapper.list();
	}

	@Override
	public PageResult<Employee> query(QueryObject qo) {
		Long count = mapper.queryCount(qo);
		if (count == 0) {
			return new PageResult<Employee>(Collections.emptyList(), 0,
					qo.getPageSize(), qo.getCurrentPage());
		}
		// 查询数据
		List<Employee> data = mapper.query(qo);
		return new PageResult<Employee>(data, count.intValue(),
				qo.getPageSize(), qo.getCurrentPage());
	}

	@Override
	public Employee checkLogin(String name, String password) {
		Employee currentUser = mapper.getUserByNameAndPassword(name,
				password);
		return currentUser;
	}

	@Override
	public Set<String> getPermission(Employee obj) {
		// 查询出用户拥有的权限
		Set<String> permissionSet = new HashSet<>();
		List<Role> roles = obj.getRoles();
		for (Role role : roles) {			
			role = roleService.get(role.getId());
			List<Permission> permissions = role.getPermissions();
			for (Permission permission : permissions) {
				permissionSet.add(permission.getExpression());
			}
		}
		return permissionSet;
	}

}
