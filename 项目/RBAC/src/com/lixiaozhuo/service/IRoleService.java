package com.lixiaozhuo.service;

import java.util.List;

import com.lixiaozhuo.domain.Role;
import com.lixiaozhuo.page.PageResult;
import com.lixiaozhuo.query.QueryObject;

public interface IRoleService {
	
void save(Role entity);
	
	void update(Role entity);
	
	void delete(Role entity);
	
	Role get(Long id);
	
	List<Role> list();
	
	PageResult<Role> query(QueryObject qo);
	
}
