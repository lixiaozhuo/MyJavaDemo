package com.lixiaozhuo.many2one.test;

import java.util.List;

import org.junit.Test;

import com.lixiaozhuo.many2one.domain.Department;
import com.lixiaozhuo.many2one.domain.Employee;
import com.lixiaozhuo.many2one.service.IDepartmentService;
import com.lixiaozhuo.many2one.service.IEmployeeService;
import com.lixiaozhuo.many2one.service.impl.DepartmentServiceImpl;
import com.lixiaozhuo.many2one.service.impl.EmployeeServiceImpl;

import lombok.Setter;

public class EmployeeDAOTest {

	@Setter
	IEmployeeService service = new EmployeeServiceImpl();

	@Setter
	IDepartmentService departmentService = new DepartmentServiceImpl();

	@Test
	public void testSave() {
		Department department = departmentService.get(2L);
		Employee obj = new Employee();
		obj.setUsername("aaa");
		obj.setDept(department);
		service.save(obj);
	}

	@Test
	public void testUpdate() {
		Department department = departmentService.get(3L);
		Employee obj = new Employee();
		obj.setId(2L);
		obj.setUsername("bbb");
		obj.setDept(department);
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
		System.out.println(obj.getClass());
		System.out.println(obj.getDept().getClass());
	}

	@Test
	public void testListAll() {
		List<Employee> list = service.list();
		for (Employee Employee : list) {
			System.out.println(Employee);
		}
	}
}
