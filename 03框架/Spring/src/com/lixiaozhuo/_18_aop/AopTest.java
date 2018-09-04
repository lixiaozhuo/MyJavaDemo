package com.lixiaozhuo._18_aop;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lixiaozhuo._20_aop_common.domain.Employee;
import com.lixiaozhuo._20_aop_common.service.IEmployeeService;

//aop编程测试
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class AopTest {
	@Autowired
	private IEmployeeService employeeServie;
	
	@Test
	public void testSave() throws Exception {
		employeeServie.save(new Employee());
		System.out.println(employeeServie.getClass());
		
	}
	
	@Test
	public void testUpdate() throws Exception {
		employeeServie.update(new Employee());	
		System.out.println(employeeServie.getClass());
	}
}
