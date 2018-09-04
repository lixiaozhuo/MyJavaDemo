package com.lixiaozhuo.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lixiaozhuo.domain.User;
import com.lixiaozhuo.service.IUserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class UserDAOTest {

	@Autowired
	IUserService service;

	@Test
	public void testSave() {
		User obj = new User();
		obj.setUsername("aaa");
		obj.setPassword("admin");
		obj.setAge(18);
		service.save(obj);
	}

	@Test
	public void testUpdate() {
		User obj = new User();
		obj.setId(2L);
		obj.setUsername("ddd");
		obj.setPassword("admin");
		obj.setAge(28);
		service.update(obj);
	}

	@Test
	public void testDelete() {
		service.delete(1L);
	}

	@Test
	public void testGet() {
		User obj = service.get(2L);
		System.out.println(obj);
	}

	@Test
	public void testListAll() {
		List<User> list = service.list();
		for (User user : list) {
			System.out.println(user);
		}
	}

}
