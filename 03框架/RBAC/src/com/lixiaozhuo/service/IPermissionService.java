package com.lixiaozhuo.service;

import java.util.List;

import com.lixiaozhuo.domain.Permission;
import com.lixiaozhuo.page.PageResult;
import com.lixiaozhuo.query.QueryObject;

public interface IPermissionService {
	
void save(Permission entity);
	
	void update(Permission entity);
	
	void delete(Permission entity);
	
	Permission get(Long id);
	
	List<Permission> list();
	
	PageResult<Permission> query(QueryObject qo);
	/**
	 * 加载权限
	 */
	void reload();
	
}
