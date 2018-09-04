package com.lixiaozhuo.one2many.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.lixiaozhuo.one2many.domain.Employee;
import com.lixiaozhuo.one2many.mapper.EmployeeMapper;
import com.lixiaozhuo.one2many.service.IEmployeeService;
import com.lixiaozhuo.one2many.utils.MyBatisUtil;

public class EmployeeServiceImpl implements IEmployeeService {

	@Override
	public void save(Employee obj) {
		SqlSession session = MyBatisUtil.getSession();
		EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
		mapper.add(obj);
		session.commit();
		session.close();
		System.out.println(obj);
	}

	@Override
	public void update(Employee obj) {
		SqlSession session = MyBatisUtil.getSession();
		// 执行更新
		EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
		mapper.update(obj);
		session.commit();
		session.close();
	}

	@Override
	public void delete(Long id) {
		SqlSession session = MyBatisUtil.getSession();
		// 执行删除
		EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
		mapper.delete(id);
		session.commit();
		session.close();
	}

	@Override
	public Employee get(Long id) {
		SqlSession session = MyBatisUtil.getSession();
		// 查询单条数据
		EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
		Employee obj = mapper.get(2L);
		session.commit();
		session.close();
		return obj;
	}

	@Override
	public List<Employee> list() {
		SqlSession session = MyBatisUtil.getSession();
		// 查询所有数据
		EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
		List<Employee> list = mapper.list();
		session.commit();
		session.close();
		return list;
	}

}
