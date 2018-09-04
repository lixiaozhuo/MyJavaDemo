package com.lixiaozhuo.many2many.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.lixiaozhuo.many2many.domain.Student;
import com.lixiaozhuo.many2many.mapper.StudentMapper;
import com.lixiaozhuo.many2many.service.IStudentService;
import com.lixiaozhuo.many2one.utils.MyBatisUtil;


public class StudentServiceImpl implements IStudentService {

	@Override
	public void save(Student obj) {
		SqlSession session = MyBatisUtil.getSession();
		StudentMapper mapper = session.getMapper(StudentMapper.class);
		mapper.add(obj);
		session.commit();
		session.close();
		System.out.println(obj);
	}

	@Override
	public void update(Student obj) {
		SqlSession session = MyBatisUtil.getSession();
		// 执行更新
		StudentMapper mapper = session.getMapper(StudentMapper.class);
		mapper.update(obj);
		session.commit();
		session.close();
	}

	@Override
	public void delete(Long id) {
		SqlSession session = MyBatisUtil.getSession();
		// 执行删除
		StudentMapper mapper = session.getMapper(StudentMapper.class);
		mapper.delete(id);
		session.commit();
		session.close();
	}

	@Override
	public Student get(Long id) {
		SqlSession session = MyBatisUtil.getSession();
		// 查询单条数据
		StudentMapper mapper = session.getMapper(StudentMapper.class);
		Student obj = mapper.get(2L);
		session.commit();
		session.close();
		return obj;
	}

	@Override
	public List<Student> list() {
		SqlSession session = MyBatisUtil.getSession();
		// 查询所有数据
		StudentMapper mapper = session.getMapper(StudentMapper.class);
		List<Student> list = mapper.list();
		session.commit();
		session.close();
		return list;
	}

}
