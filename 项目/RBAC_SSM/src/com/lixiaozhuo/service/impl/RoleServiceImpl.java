package com.lixiaozhuo.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lixiaozhuo.domain.Permission;
import com.lixiaozhuo.domain.Role;
import com.lixiaozhuo.mapper.RoleMapper;
import com.lixiaozhuo.page.PageResult;
import com.lixiaozhuo.query.QueryObject;
import com.lixiaozhuo.service.IRoleService;

import lombok.Setter;

@Service
public class RoleServiceImpl implements IRoleService {
	@Setter
	@Autowired
	RoleMapper mapper;

	@Override
	public void save(Role entity) {
		mapper.save(entity);
		// 处理关系
		for (Permission per : entity.getPermissions()) {
			mapper.insertRelation(entity.getId(), per.getId());
		}
	}

	@Override
	public void save(Role entity, String[] ids) {
		mapper.save(entity);
		if(ids == null){
			return;
		}
		// 处理关系
		for (String per : ids) {
			mapper.insertRelation(entity.getId(), Long.valueOf(per));
		}
	}

	@Override
	public void update(Role entity) {
		// 删除对应关系
		mapper.deleteRelation(null, entity.getId());
		mapper.update(entity);
		// 处理关系
		// 处理关系
		for (Permission per : entity.getPermissions()) {
			mapper.insertRelation(entity.getId(), per.getId());
		}
	}

	@Override
	public void update(Role entity, String[] ids) {
		// 删除对应关系
		mapper.deleteRelation(entity.getId(),null);
		mapper.update(entity);
		if(ids == null){
			return;
		}
		// 处理关系
		for (String per : ids) {
			mapper.insertRelation(entity.getId(), Long.valueOf(per));
		}
	}

	@Override
	public void delete(Long id) {
		// 删除对应关系
		mapper.deleteRelation(id, null);
		mapper.delete(id);
	}

	@Override
	public Role get(Long id) {
		return mapper.get(id);
	}

	@Override
	public List<Role> list() {
		return mapper.list();
	}

	@Override
	public PageResult<Role> query(QueryObject qo) {
		Long count = mapper.queryCount(qo);
		if (count == 0) {
			return new PageResult<Role>(Collections.emptyList(), 0,
					qo.getPageSize(), qo.getCurrentPage());
		}
		// 查询数据
		List<Role> data = mapper.query(qo);
		return new PageResult<Role>(data, count.intValue(), qo.getPageSize(),
				qo.getCurrentPage());
	}

}
