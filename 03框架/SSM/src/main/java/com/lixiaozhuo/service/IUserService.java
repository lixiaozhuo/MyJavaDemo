package com.lixiaozhuo.service;

import java.util.List;

import com.lixiaozhuo.domain.User;

public interface IUserService {
	void save(User obj);
	
	void update(User obj);
	
	void delete(Long id);
	
	User get(Long id);
	
	List<User> list();
}
