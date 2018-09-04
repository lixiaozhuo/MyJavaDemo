package com.lixiaozhuo._01_crud.test;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;

import com.lixiaozhuo._01_crud.dao.IUserDAO;
import com.lixiaozhuo._01_crud.dao.impl.UserDAOImpl;
import com.lixiaozhuo._01_crud.domain.User;

public class UserDAOTest {

	IUserDAO dao = new UserDAOImpl();

	@Test
	public void testSave() {
		User obj = new User();
		obj.setName("ddd");
		obj.setSalary(new BigDecimal("30000"));
		dao.save(obj);
	}

	@Test
	public void testUpdate() {
		User obj = new User();
		obj.setId(4L);
		obj.setName("ddd");
		obj.setSalary(new BigDecimal("3000"));
		dao.update(obj);
	}

	@Test
	public void testDelete() {
		User obj = new User();
		obj.setId(4L);
		dao.delete(obj);
	}

	@Test
	public void testGet() {
		User user = dao.get(1L);
		System.out.println(user);
	}

	@Test
	public void testListAll() {
		List<User> list = dao.listAll();
		for (User user : list) {
			System.out.println(user);
		}
	}

}
