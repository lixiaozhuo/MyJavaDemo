package com.lixiaozhuo._19_aop_annon;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lixiaozhuo._19_aop_annon.aop_common.domain.Employee;
import com.lixiaozhuo._19_aop_annon.aop_common.service.IEmployeeService;

//aop编程测试(注解版)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class AopTest {
	@Autowired
	private IEmployeeService emplServie;

	@Test
	public void testSave() throws Exception {
		emplServie.save(new Employee());
		System.out.println(emplServie.getClass());
	}

	@Test
	public void testUpdate() throws Exception {
		emplServie.update(new Employee());
		System.out.println(emplServie.getClass());
	}
}
