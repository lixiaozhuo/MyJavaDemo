package com.lixiaozhuo.many2many.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.lixiaozhuo.many2many.domain.Student;
import com.lixiaozhuo.many2many.domain.Teacher;
import com.lixiaozhuo.many2many.mapper.TeacherMapper;
import com.lixiaozhuo.many2many.service.ITeacherService;
import com.lixiaozhuo.many2one.utils.MyBatisUtil;

public class TeacherServiceImpl implements ITeacherService {

	@Override
	public void save(Teacher obj) {
		SqlSession session = MyBatisUtil.getSession();
		TeacherMapper mapper = session.getMapper(TeacherMapper.class);
		mapper.add(obj);
		// 处理关系
		for (Student stu : obj.getStudents()) {
			System.out.println(stu);
			mapper.insertRelation(stu.getId(),obj.getId());
		}
		session.commit();
		session.close();
		System.out.println(obj);
	}

	@Override
	public void update(Teacher obj) {
		SqlSession session = MyBatisUtil.getSession();
		// 执行更新
		TeacherMapper mapper = session.getMapper(TeacherMapper.class);
		mapper.update(obj);
		session.commit();
		session.close();
	}

	@Override
	public void delete(Long id) {
		SqlSession session = MyBatisUtil.getSession();
		// 执行删除
		TeacherMapper mapper = session.getMapper(TeacherMapper.class);
		//删除对应关系
		mapper.deleteRelation(null, id);		
		mapper.delete(id);
		session.commit();
		session.close();
	}

	@Override
	public Teacher get(Long id) {
		SqlSession session = MyBatisUtil.getSession();
		// 查询单条数据
		TeacherMapper mapper = session.getMapper(TeacherMapper.class);
		Teacher obj = mapper.get(id);
		session.commit();
		session.close();
		return obj;
	}

	@Override
	public List<Teacher> list() {
		SqlSession session = MyBatisUtil.getSession();
		// 查询所有数据
		TeacherMapper mapper = session.getMapper(TeacherMapper.class);
		List<Teacher> list = mapper.list();
		session.commit();
		session.close();
		return list;
	}

}
