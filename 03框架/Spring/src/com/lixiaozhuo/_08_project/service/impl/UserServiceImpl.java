package com.lixiaozhuo._08_project.service.impl;

import com.lixiaozhuo._08_project.dao.IUserDAO;
import com.lixiaozhuo._08_project.domain.User;
import com.lixiaozhuo._08_project.service.IUserService;

import lombok.Setter;

public class UserServiceImpl implements IUserService{
	@Setter
	private IUserDAO userDAO;
	@Override
	public void save(User u) {
		System.out.println("service调用DAO的保存方法");
		userDAO.save(u);
	}

}
