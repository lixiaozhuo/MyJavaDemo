package com.lixiaozhuo.one2many.test;

import java.util.List;

import org.junit.Test;

import com.lixiaozhuo.one2many.domain.Employee;
import com.lixiaozhuo.one2many.service.IEmployeeService;
import com.lixiaozhuo.one2many.service.impl.EmployeeServiceImpl;

import lombok.Setter;

public class EmployeeDAOTest {

	@Setter
	IEmployeeService service = new EmployeeServiceImpl();


	@Test
	public void testSave() {
		Employee obj = new Employee();
		obj.setUsername("aaa");
		service.save(obj);
	}

	@Test
	public void testUpdate() {
		Employee obj = new Employee();
		obj.setId(2L);
		obj.setUsername("bbb");
		service.update(obj);
	}

	@Test
	public void testDelete() {
		service.delete(1L);
	}

	@Test
	public void testGet() {
		Employee obj = service.get(2L);
		System.out.println(obj);
	}

	@Test
	public void testListAll() {
		List<Employee> list = service.list();
		for (Employee Employee : list) {
			System.out.println(Employee);
		}
	}
}
