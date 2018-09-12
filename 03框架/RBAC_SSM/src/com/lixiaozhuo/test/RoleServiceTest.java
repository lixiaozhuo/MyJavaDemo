package com.lixiaozhuo.test;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lixiaozhuo.domain.Role;
import com.lixiaozhuo.page.PageResult;
import com.lixiaozhuo.query.RoleQueryObject;
import com.lixiaozhuo.service.IRoleService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class RoleServiceTest {

	@Autowired
	IRoleService service;
	@Test
	public void testSave() {
		
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		service.delete(8L);
	}

	@Test
	public void testGet() {
		System.out.println(service.get(5L));
	}

	@Test
	public void testList() {
		List<Role> list = service.list();
		for (Role role : list) {
			System.out.println(role);
		}
	}

	@Test
	public void testQuery() {
		RoleQueryObject qo = new RoleQueryObject();	
		PageResult<Role> result = service.query(qo);
		System.out.println(result.getData());
	}

}
