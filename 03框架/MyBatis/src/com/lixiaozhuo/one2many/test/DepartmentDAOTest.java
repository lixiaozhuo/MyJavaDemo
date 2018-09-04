package com.lixiaozhuo.one2many.test;

import java.util.List;

import org.junit.Test;

import com.lixiaozhuo.one2many.domain.Department;
import com.lixiaozhuo.one2many.domain.Employee;
import com.lixiaozhuo.one2many.service.IDepartmentService;
import com.lixiaozhuo.one2many.service.IEmployeeService;
import com.lixiaozhuo.one2many.service.impl.DepartmentServiceImpl;
import com.lixiaozhuo.one2many.service.impl.EmployeeServiceImpl;

import lombok.Setter;

public class DepartmentDAOTest {

	@Setter
	IDepartmentService service = new DepartmentServiceImpl();

	IEmployeeService empService = new EmployeeServiceImpl();

	@Test
	public void testSave() {
		Employee emp1 = new Employee();
		emp1.setUsername("aaa");
		empService.save(emp1);
		Employee emp2 = new Employee();
		emp2.setUsername("bbb");
		empService.save(emp2);

		Department obj = new Department();
		obj.setName("研发部");
		obj.getEmps().add(emp1);
		obj.getEmps().add(emp2);

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
		service.delete(5L);
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
