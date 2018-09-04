package com.lixiaozhuo._12_project_annon.dao.impl;

import org.springframework.stereotype.Repository;

import com.lixiaozhuo._12_project_annon.dao.IUserDAO;
import com.lixiaozhuo._12_project_annon.domain.User;

@Repository//标注数据访问组件 即DAO组件
public class UserDAOImpl implements IUserDAO {
	private String conn;

	@Override
	public void save(User u) {
		System.out.println(conn);
		System.out.println("DAO保存对象........");
	}

}
