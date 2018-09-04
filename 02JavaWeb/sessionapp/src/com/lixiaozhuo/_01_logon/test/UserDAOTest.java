package com.lixiaozhuo._01_logon.test;

import org.junit.Test;

import com.lixiaozhuo._01_logon.dao.IUserDAO;
import com.lixiaozhuo._01_logon.dao.impl.UserDAOImpl;
import com.lixiaozhuo._01_logon.domain.User;

public class UserDAOTest {
	private IUserDAO dao = new UserDAOImpl();
	
	@Test
	public void testGetUserByUsername() throws Exception {
		User user = dao.getUserByUsername("root1");
		System.out.println(user);
	}
}
