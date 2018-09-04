package com.lixiaozhuo._21_jdbc.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lixiaozhuo._21_jdbc.dao.IEmployeeDAO;
import com.lixiaozhuo._21_jdbc.dao.impl.EmployeeDAOImpl;
import com.lixiaozhuo._21_jdbc.domain.Employee;

//crud测试
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class EmployeeDAOTest {
	@Autowired
	IEmployeeDAO employeeDAO = new EmployeeDAOImpl();
	
	@Test
	public void testSave() {
		Employee obj = new Employee();
		obj.setName("aaa");
		obj.setAge(18);
		employeeDAO.save(obj);
	}

	@Test
	public void testUpdate() {
		Employee obj = new Employee();
		obj.setId(1L);
		obj.setName("bbb");
		obj.setAge(18);
		employeeDAO.update(obj);
	}

	@Test
	public void testDelete() {
		employeeDAO.delete(4L);
	}

	@Test
	public void testGet() {
		Employee obj = employeeDAO.get(1l);
		System.out.println(obj);
	}

	@Test
	public void testList() {
		List<Employee> list = employeeDAO.list();
		for (Employee obj : list) {
			System.out.println(obj);
		}
	}

}
