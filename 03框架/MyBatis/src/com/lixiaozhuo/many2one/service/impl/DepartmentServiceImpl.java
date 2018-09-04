package com.lixiaozhuo.many2one.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.lixiaozhuo.many2one.domain.Department;
import com.lixiaozhuo.many2one.mapper.DepartmentMapper;
import com.lixiaozhuo.many2one.service.IDepartmentService;
import com.lixiaozhuo.many2one.utils.MyBatisUtil;


public class DepartmentServiceImpl implements IDepartmentService {

	@Override
	public void save(Department obj) {
		SqlSession session = MyBatisUtil.getSession();
		DepartmentMapper mapper = session.getMapper(DepartmentMapper.class);
		mapper.add(obj);
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
		// 执行删除
		DepartmentMapper mapper = session.getMapper(DepartmentMapper.class);
		mapper.delete(id);
		session.commit();
		session.close();
	}

	@Override
	public Department get(Long id) {
		SqlSession session = MyBatisUtil.getSession();
		// 查询单条数据
		DepartmentMapper mapper = session.getMapper(DepartmentMapper.class);
		Department obj = mapper.get(2L);
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
