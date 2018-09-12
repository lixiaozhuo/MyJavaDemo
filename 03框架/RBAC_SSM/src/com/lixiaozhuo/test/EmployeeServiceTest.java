package com.lixiaozhuo.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lixiaozhuo.domain.Employee;
import com.lixiaozhuo.page.PageResult;
import com.lixiaozhuo.query.EmployeeQueryObject;
import com.lixiaozhuo.service.IEmployeeService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class EmployeeServiceTest {

	@Autowired
	IEmployeeService service;

	@Test
	public void testSave() {
		Employee obj = new Employee();
		obj.setName("aaa");
		service.save(obj);
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
			service.save(obj);
		}
	}

	@Test
	public void testUpdate() {
		Employee obj = new Employee();
		obj.setId(1L);
		obj.setName("bba");
		service.update(obj);
	}

	@Test
	public void testDelete() {
		service.delete(2L);
	}

	@Test
	public void testGet() {
		Employee dept = service.get(1L);
		System.out.println(dept);
	}

	@Test
	public void testList() {
		List<Employee> list = service.list();
		for (Employee obj : list) {
			System.out.println(obj);
		}
	}
	
	@Test
	public void testQuery() {
		EmployeeQueryObject qo = new EmployeeQueryObject();
		qo.setKeyword("0");		
		PageResult<Employee> result = service.query(qo);
		System.out.println(result.getData());
	}
}
