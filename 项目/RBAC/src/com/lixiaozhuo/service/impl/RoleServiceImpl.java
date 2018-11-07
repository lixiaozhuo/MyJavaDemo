package com.lixiaozhuo.service.impl;

import java.util.List;

import com.lixiaozhuo.dao.IRoleDAO;
import com.lixiaozhuo.domain.Role;
import com.lixiaozhuo.page.PageResult;
import com.lixiaozhuo.query.QueryObject;
import com.lixiaozhuo.service.IRoleService;

import lombok.Setter;

public class RoleServiceImpl implements IRoleService {
	@Setter
	private IRoleDAO roleDAO;

	@Override
	public void save(Role entity) {
		roleDAO.save(entity);
	}

	@Override
	public void update(Role entity) {
		roleDAO.update(entity);
	}

	@Override
	public void delete(Role entity) {
		roleDAO.delete(entity);
	}

	@Override
	public Role get(Long id) {
		return roleDAO.get(id);
	}

	@Override
	public List<Role> list() {
		return roleDAO.list();
	}

	@Override
	public PageResult<Role> query(QueryObject qo) {
		return roleDAO.query(qo);
	}

}
