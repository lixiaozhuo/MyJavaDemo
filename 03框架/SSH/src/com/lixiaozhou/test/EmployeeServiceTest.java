package com.lixiaozhou.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lixiaozhou.domain.Employee;
import com.lixiaozhou.service.IEmployeeService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class EmployeeServiceTest {
	@Autowired
	IEmployeeService employeeService;

	@Test
	public void testSave() {
		Employee obj = new Employee();
		obj.setName("aaa");
		obj.setAge(18);
		employeeService.save(obj);
	}

	@Test
	public void testUpdate() {
		Employee obj = new Employee();
		obj.setId(1L);
		obj.setName("bbb");
		obj.setAge(18);
		employeeService.update(obj);
	}

	@Test
	public void testDelete() {
		Employee obj = new Employee();
		obj.setId(4L);
		employeeService.delete(obj);
	}

	@Test
	public void testGet() {
		Employee obj = employeeService.get(1L);
		System.out.println(obj);
	}

	@Test
	public void testList() {
		List<Employee> list = employeeService.list();
		for (Employee obj : list) {
			System.out.println(obj);
		}
	}
}
