package com.lixiaozhuo.service.impl;

import java.util.List;

import com.lixiaozhuo.dao.IDepartmentDAO;
import com.lixiaozhuo.domain.Department;
import com.lixiaozhuo.page.PageResult;
import com.lixiaozhuo.query.QueryObject;
import com.lixiaozhuo.service.IDepartmentService;

import lombok.Setter;

public class DepartmentServiceImpl implements IDepartmentService {
	@Setter
	IDepartmentDAO departmentDAO;

	@Override
	public void save(Department entity) {
		departmentDAO.save(entity);
	}

	@Override
	public void update(Department entity) {
		departmentDAO.update(entity);
	}

	@Override
	public void delete(Department entity) {
		departmentDAO.delete(entity);
	}

	@Override
	public Department get(Long id) {
		return departmentDAO.get(id);
	}

	@Override
	public List<Department> list() {
		return departmentDAO.list();
	}

	@Override
	public PageResult<Department> query(QueryObject qo) {
		return departmentDAO.query(qo);
	}

}
