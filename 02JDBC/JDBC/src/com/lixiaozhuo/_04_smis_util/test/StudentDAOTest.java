package com.lixiaozhuo._04_smis_util.test;

import java.util.List;
import org.junit.Test;
import com.lixiaozhuo._04_smis_util.dao.IStudentDAO;
import com.lixiaozhuo._04_smis_util.dao.impl.StudentDAOImpl;
import com.lixiaozhuo._04_smis_util.domain.Student;

//测试类
public class StudentDAOTest {
	IStudentDAO stuD = new StudentDAOImpl();

	// 测试插入学生信息
	@Test
	public void testSave() {
		Student stu = new Student(null, "aaa", 18);
		stuD.save(stu);
	}

	// 测试删除学生信息
	@Test
	public void testDelete() {
		stuD.delete(5L);
	}

	// 测试修改学生信息
	@Test
	public void testUpdate() {
		Student stu = new Student(5L, "bbb", 19);
		stuD.update(stu);
	}

	// 测试根据id查询学生信息
	@Test
	public void testGet() {
		Student stu = stuD.get(5L);
		System.out.println(stu);
	}

	// 测试查询所有学生信息
	@Test
	public void testList() {
		List<Student> stus = stuD.list();
		for (Student stu : stus) {
			System.out.println(stu);
		}
	}

}
