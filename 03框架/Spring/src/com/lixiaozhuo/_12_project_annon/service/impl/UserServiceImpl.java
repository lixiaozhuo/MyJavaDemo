package com.lixiaozhuo._12_project_annon.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lixiaozhuo._12_project_annon.dao.IUserDAO;
import com.lixiaozhuo._12_project_annon.domain.User;
import com.lixiaozhuo._12_project_annon.service.IUserService;

@Service // 标注业务层组件
public class UserServiceImpl implements IUserService {
	@Autowired
	private IUserDAO userDAO;

	@Override
	public void save(User u) {
		System.out.println("service调用DAO的保存方法");
		userDAO.save(u);
	}

}
