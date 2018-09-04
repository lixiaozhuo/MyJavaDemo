package com.lixiaozhuo.many2many.test;

import java.util.List;

import org.junit.Test;

import com.lixiaozhuo.many2many.domain.Student;
import com.lixiaozhuo.many2many.domain.Teacher;
import com.lixiaozhuo.many2many.service.IStudentService;
import com.lixiaozhuo.many2many.service.ITeacherService;
import com.lixiaozhuo.many2many.service.impl.StudentServiceImpl;
import com.lixiaozhuo.many2many.service.impl.TeacherServiceImpl;

import lombok.Setter;

public class TeacherDAOTest {

	@Setter
	ITeacherService service = new TeacherServiceImpl();

	@Setter
	IStudentService StudentService = new StudentServiceImpl();

	@Test
	public void testSave() {
		Student stu1 = new Student();
		stu1.setName("aaa");
		Student stu2 = new Student();
		stu2.setName("bbb");
		StudentService.save(stu1);
		StudentService.save(stu2);
		Teacher tea1 = new Teacher();
		tea1.setName("111");
		Teacher tea2 = new Teacher();
		tea2.setName("222");

		tea1.getStudents().add(stu1);
		tea1.getStudents().add(stu2);

		tea2.getStudents().add(stu1);
		tea2.getStudents().add(stu2);
		service.save(tea1);
		service.save(tea2);
	}

	@Test
	public void testUpdate() {
		Teacher obj = new Teacher();
		obj.setId(2L);
		obj.setName("李老师");
		service.update(obj);
	}

	@Test
	public void testDelete() {
		service.delete(8L);
	}

	@Test
	public void testGet() {
		Teacher obj = service.get(10L);
		System.out.println(obj);
	}

	@Test
	public void testListAll() {
		List<Teacher> list = service.list();
		for (Teacher Teacher : list) {
			System.out.println(Teacher);
		}
	}
}
