package com.lixiaozhuo.one2many.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.lixiaozhuo.one2many.domain.Department;
import com.lixiaozhuo.one2many.domain.Employee;
import com.lixiaozhuo.one2many.mapper.DepartmentMapper;
import com.lixiaozhuo.one2many.service.IDepartmentService;
import com.lixiaozhuo.one2many.utils.MyBatisUtil;

public class DepartmentServiceImpl implements IDepartmentService {

	@Override
	public void save(Department obj) {
		SqlSession session = MyBatisUtil.getSession();
		DepartmentMapper mapper = session.getMapper(DepartmentMapper.class);
		// 保存部门
		mapper.add(obj);
		// 处理关系
		for (Employee emp : obj.getEmps()) {
			mapper.updateRelation(obj.getId(), emp.getId());
		}
		session.commit();
		session.close();
		System.out.println(obj);
	}

	@Override
	public void update(Department obj) {
		SqlSession session = MyBatisUtil.getSession();
		// 执行更新
		DepartmentMapper mapper = session.getMapper(DepartmentMapper.class);
		mapper.update(obj);
		session.commit();
		session.close();
	}

	@Override
	public void delete(Long id) {
		SqlSession session = MyBatisUtil.getSession();	
		DepartmentMapper mapper = session.getMapper(DepartmentMapper.class);
		Department dept = get(id);
		// 处理关系
		for (Employee emp : dept.getEmps()) {
			mapper.updateRelation(null, emp.getId());
		}
		// 执行删除
		mapper.delete(id);
		session.commit();
		session.close();
	}

	@Override
	public Department get(Long id) {
		SqlSession session = MyBatisUtil.getSession();
		// 查询单条数据
		DepartmentMapper mapper = session.getMapper(DepartmentMapper.class);
		Department obj = mapper.get(id);
		session.commit();
		session.close();
		return obj;
	}

	@Override
	public List<Department> list() {
		SqlSession session = MyBatisUtil.getSession();
		// 查询所有数据
		DepartmentMapper mapper = session.getMapper(DepartmentMapper.class);
		List<Department> list = mapper.list();
		session.commit();
		session.close();
		return list;
	}

}
