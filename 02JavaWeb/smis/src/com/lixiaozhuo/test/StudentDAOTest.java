package com.lixiaozhuo.test;

import java.util.List;

import org.junit.Test;

import com.lixiaozhuo.dao.IStudentDAO;
import com.lixiaozhuo.dao.impl.StudentDAOImpl;
import com.lixiaozhuo.domain.Student;

//测试类
public class StudentDAOTest {
	IStudentDAO stuDAO = new StudentDAOImpl();

	// 测试插入学生信息
	@Test
	public void testSave() {
		Student stu = new Student(null, "aaa", 18);
		stuDAO.save(stu);
	}

	// 测试删除学生信息
	@Test
	public void testUpdate() {
		Student stu = new Student(1L, "bbb", 28);
		stuDAO.update(stu);
	}

	// 测试修改学生信息
	@Test
	public void testDelete() {
		stuDAO.delete(1L);
	}

	// 测试根据id查询学生信息
	@Test
	public void testGet() {
		Student stu = stuDAO.get(805L);
		System.out.println(stu);
	}

	// 测试查询所有学生信息
	@Test
	public void testList() {
		List<Student> stus = stuDAO.list();
		for (Student stu : stus) {
			System.out.println(stu);
		}
	}


}
