package com.lixiaozhuo.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lixiaozhuo.domain.Department;
import com.lixiaozhuo.service.IDepartmentService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class DepartmentServiceTest {
	
	@Autowired
	IDepartmentService service;
		
	@Test
	public void testSave() {
		Department obj = new Department();
		obj.setName("aaa");
		obj.setSn("11");
		service.save(obj);
	}

	@Test
	public void testUpdate() {
		Department obj = new Department();
		obj.setId(1L);
		obj.setName("bba");
		obj.setSn("11");
		service.update(obj);
	}

	@Test
	public void testDelete() {
		service.delete(2L);
	}

	@Test
	public void testGet() {
		Department obj = service.get(1L);
		System.out.println(obj);
	}

	@Test
	public void testList() {
		List<Department> list = service.list();
		for (Department obj : list) {			
			System.out.println(obj);
		}
	}

}
