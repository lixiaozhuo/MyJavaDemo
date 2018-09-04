package com.lixiaozhuo.many2many.test;

import java.util.List;

import org.junit.Test;

import com.lixiaozhuo.many2many.domain.Student;
import com.lixiaozhuo.many2many.service.IStudentService;
import com.lixiaozhuo.many2many.service.impl.StudentServiceImpl;

import lombok.Setter;

public class StudentDAOTest {

	@Setter
	IStudentService service = new StudentServiceImpl();

	@Test
	public void testSave() {
		Student obj = new Student();
		obj.setName("张三");
		service.save(obj);
	}

	@Test
	public void testUpdate() {
		Student obj = new Student();
		obj.setId(2L);
		obj.setName("李四");
		service.update(obj);
	}

	@Test
	public void testDelete() {
		service.delete(1L);
	}

	@Test
	public void testGet() {
		Student obj = service.get(2L);
		System.out.println(obj);
	}

	@Test
	public void testListAll() {
		List<Student> list = service.list();
		for (Student Student : list) {
			System.out.println(Student);
		}
	}
}
