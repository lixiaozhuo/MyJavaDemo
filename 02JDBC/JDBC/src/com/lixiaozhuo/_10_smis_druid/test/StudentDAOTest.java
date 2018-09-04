package com.lixiaozhuo._10_smis_druid.test;

import java.util.List;
import org.junit.Test;
import com.lixiaozhuo._10_smis_druid.dao.IStudentDAO;
import com.lixiaozhuo._10_smis_druid.dao.impl.StudentDAOImpl;
import com.lixiaozhuo._10_smis_druid.domain.Student;

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
	public void testDelete() {
		stuDAO.delete(11L);
	}

	// 测试修改学生信息
	@Test
	public void testUpdate() {
		Student stu = new Student(11L, "bbb", 29);
		stuDAO.update(stu);
	}

	// 测试根据id查询学生信息
	@Test
	public void testGet() {
		Student stu = stuDAO.get(11L);
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
