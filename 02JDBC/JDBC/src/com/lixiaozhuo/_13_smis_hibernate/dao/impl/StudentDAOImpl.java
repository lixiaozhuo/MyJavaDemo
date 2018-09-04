package com.lixiaozhuo._13_smis_hibernate.dao.impl;

import java.util.List;

import com.lixiaozhuo._13_smis_hibernate.dao.IStudentDAO;
import com.lixiaozhuo._13_smis_hibernate.domain.Student;
import com.lixiaozhuo._13_smis_hibernate.template.HibernateTemplate;

//DAO接口实现类
public class StudentDAOImpl implements IStudentDAO {
	// 插入学生信息
	@Override
	public void save(Student stu) {
		try {
			HibernateTemplate.save(stu);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 修改学生信息
	@Override
	public void update(Student stu) {
		try {
			HibernateTemplate.update(stu);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 删除学生信息
	@Override
	public void delete(Long id) {
		try {
			HibernateTemplate.delete(10L, Student.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 根据id查询学生信息
	@Override
	public Student get(Long id) {
		try {
			return HibernateTemplate.get(835L, Student.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// 查询所有学生信息
	@Override
	public List<Student> list() {
		try {
			return HibernateTemplate.list(Student.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;	
	}
}
