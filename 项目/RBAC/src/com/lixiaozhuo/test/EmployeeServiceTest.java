package com.lixiaozhuo.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lixiaozhuo.domain.Employee;
import com.lixiaozhuo.service.IEmployeeService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class EmployeeServiceTest {

	@Autowired
	IEmployeeService employeeService;

	@Test
	public void testSave() {
		Employee obj = new Employee();
		obj.setName("aaa");
		employeeService.save(obj);
	}

	// 批量添加数据
	@Test
	public void testSave1() {
		for (int i = 0; i < 20; i++) {
			Employee obj = new Employee();
			obj.setPassword("admin");
			obj.setAge(18);
			obj.setAdmin(false);
			StringBuilder str = new StringBuilder();
			if (i < 10) {
				obj.setName("测试" + "0" + i);
				str.append(i).append(i).append(i).append(i);
			} else {
				obj.setName("测试" + i);
				str.append(i).append(i);
			}
			obj.setEmail(str.toString() + "@qq.com");
			employeeService.save(obj);
		}
	}

	@Test
	public void testUpdate() {
		Employee obj = new Employee();
		obj.setId(1L);
		obj.setName("bba");
		employeeService.update(obj);
	}

	@Test
	public void testDelete() {
		Employee obj = new Employee();
		obj.setId(2L);
		employeeService.delete(obj);
	}

	@Test
	public void testGet() {
		Employee dept = employeeService.get(1L);
		System.out.println(dept);
	}

	@Test
	public void testList() {
		List<Employee> list = employeeService.list();
		for (Employee obj : list) {
			System.out.println(obj);
		}
	}

}
