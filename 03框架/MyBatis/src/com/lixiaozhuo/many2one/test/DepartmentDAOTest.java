package com.lixiaozhuo.many2one.test;

import java.util.List;

import org.junit.Test;

import com.lixiaozhuo.many2one.domain.Department;
import com.lixiaozhuo.many2one.service.IDepartmentService;
import com.lixiaozhuo.many2one.service.impl.DepartmentServiceImpl;

import lombok.Setter;

public class DepartmentDAOTest {

	@Setter
	IDepartmentService service = new DepartmentServiceImpl();

	@Test
	public void testSave() {
		Department obj = new Department();
		obj.setName("研发部");
		service.save(obj);
	}

	@Test
	public void testUpdate() {
		Department obj = new Department();
		obj.setId(2L);
		obj.setName("技术部");
		service.update(obj);
	}

	@Test
	public void testDelete() {
		service.delete(1L);
	}

	@Test
	public void testGet() {
		Department obj = service.get(2L);
		System.out.println(obj);
	}

	@Test
	public void testListAll() {
		List<Department> list = service.list();
		for (Department Department : list) {
			System.out.println(Department);
		}
	}
}
