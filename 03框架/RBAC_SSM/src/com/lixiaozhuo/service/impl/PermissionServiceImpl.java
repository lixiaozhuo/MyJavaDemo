package com.lixiaozhuo.service.impl;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import com.lixiaozhuo.domain.Permission;
import com.lixiaozhuo.mapper.PermissionMapper;
import com.lixiaozhuo.page.PageResult;
import com.lixiaozhuo.query.QueryObject;
import com.lixiaozhuo.service.IPermissionService;
import com.lixiaozhuo.utils.PermissionUtil;
import com.lixiaozhuo.utils.RequiredPermission;
import com.lixiaozhuo.web.controller.BaseController;

import lombok.Setter;

@Service
public class PermissionServiceImpl
		implements IPermissionService, ApplicationContextAware {
	@Setter
	@Autowired
	PermissionMapper mapper;

	ApplicationContext context;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		context = applicationContext;
	}

	/**
	 * 加载权限
	 */
	@Override
	public void reload() {
		// 查询出数据库所有的权限表达式
		List<Permission> permissions = mapper.list();
		// 存储数据库中所有权限的表达式
		Set<String> permissionExpressions = new HashSet<>();
		for (Permission p : permissions) {
			permissionExpressions.add(p.getExpression());
		}
		// 获取BaseAction类的所有子类中的方法
		Map<String, BaseController> map = context
				.getBeansOfType(BaseController.class);
		// 遍历所有Action
		for (Object controller : map.values()) {
			// 获取Action中的方法
			Method[] methods = controller.getClass().getDeclaredMethods();
			// 遍历方法,寻找需要加入权限的方法
			for (Method method : methods) {
				// 获取改方法对应的权限表达式
				String permissionExpression = PermissionUtil
						.buildPermissionExpression(method);
				// 数据库中已存在此权限,跳过该方法
				if (permissionExpressions.contains(permissionExpression)) {
					continue;
				}
				// 存在@RequiredPermission注解
				if (method.isAnnotationPresent(RequiredPermission.class)) {
					RequiredPermission annotation = method
							.getDeclaredAnnotation(RequiredPermission.class);
					Permission p = new Permission();
					// 设置权限名称
					p.setName(annotation.value());
					// 设置权限表达式
					p.setExpression(permissionExpression);
					// 保存此权限
					save(p);
				}
			}
		}

	}

	@Override
	public void save(Permission entity) {
		mapper.save(entity);
	}

	@Override
	public void update(Permission entity) {
		mapper.update(entity);
	}

	@Override
	public void delete(Long id) {
		mapper.delete(id);
	}

	@Override
	public Permission get(Long id) {
		return mapper.get(id);
	}

	@Override
	public List<Permission> list() {
		return mapper.list();
	}

	@Override
	public PageResult<Permission> query(QueryObject qo) {
		Long count = mapper.queryCount(qo);
		if (count == 0) {
			return new PageResult<Permission>(Collections.emptyList(), 0,
					qo.getPageSize(), qo.getCurrentPage());
		}
		// 查询数据
		List<Permission> data = mapper.query(qo);
		return new PageResult<Permission>(data, count.intValue(),
				qo.getPageSize(), qo.getCurrentPage());
	}

}
