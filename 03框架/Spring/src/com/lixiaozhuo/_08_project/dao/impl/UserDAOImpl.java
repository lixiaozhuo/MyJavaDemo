package com.lixiaozhuo._08_project.dao.impl;

import com.lixiaozhuo._08_project.dao.IUserDAO;
import com.lixiaozhuo._08_project.domain.User;

import lombok.Setter;

public class UserDAOImpl implements IUserDAO{
	@Setter
	private String conn;
	@Override
	public void save(User u) {
		System.out.println(conn);
		System.out.println("DAO保存对象........");
	}

}
