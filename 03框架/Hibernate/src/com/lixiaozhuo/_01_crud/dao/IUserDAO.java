package com.lixiaozhuo._01_crud.dao;

import java.util.List;

import com.lixiaozhuo._01_crud.domain.User;

public interface IUserDAO {
	void save(User obj);
	
	void update(User obj);

	void delete(User obj);
	
	User get(Long id);
	
	List<User> listAll();
}
