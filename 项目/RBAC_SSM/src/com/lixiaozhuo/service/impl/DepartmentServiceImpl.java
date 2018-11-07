package com.lixiaozhuo.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lixiaozhuo.domain.Department;
import com.lixiaozhuo.mapper.DepartmentMapper;
import com.lixiaozhuo.page.PageResult;
import com.lixiaozhuo.query.QueryObject;
import com.lixiaozhuo.service.IDepartmentService;

@Service
public class DepartmentServiceImpl implements IDepartmentService {
	
	@Autowired
	DepartmentMapper mapper;

	@Override
	public void save(Department entity) {
		mapper.save(entity);
	}

	@Override
	public void update(Department entity) {
		mapper.update(entity);
	}

	@Override
	public void delete(Long id) {
		mapper.delete(id);
	}

	@Override
	public Department get(Long id) {
		return mapper.get(id);
	}

	@Override
	public List<Department> list() {
		return mapper.list();
	}

	@Override
	public PageResult<Department> query(QueryObject qo) {
		Long count = mapper.queryCount(qo);
		if (count == 0) {
			return new PageResult<Department>(Collections.emptyList(), 0,
					qo.getPageSize(), qo.getCurrentPage());
		}
		// 查询数据
		List<Department> data = mapper.query(qo);
		return new PageResult<Department>(data, count.intValue(),
				qo.getPageSize(), qo.getCurrentPage());
	}

}
