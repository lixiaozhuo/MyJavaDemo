package com.lixiaozhuo._09_tag_extends;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//继承标签测试
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class TagExtendsTest {
	@Autowired
	private DepartmentDAOImpl departmentDAO;
	@Autowired
	private EmployeeDAOImpl employeeDAO;

	@Test
	public void test() throws Exception {
		departmentDAO.save(new Department());
		employeeDAO.save(new Employee());
	}
}
