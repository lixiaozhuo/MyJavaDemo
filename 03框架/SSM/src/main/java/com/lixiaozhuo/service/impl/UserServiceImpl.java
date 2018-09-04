package com.lixiaozhuo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lixiaozhuo.domain.User;
import com.lixiaozhuo.mapper.UserMapper;
import com.lixiaozhuo.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	//@Setter
	@Autowired
	UserMapper mapper;

	public void save(User obj) {
		mapper.add(obj);
		System.out.println(obj);
	}

	public void update(User obj) {
		mapper.update(obj);
	}

	public void delete(Long id) {
		mapper.delete(id);
	}

	public User get(Long id) {
		User obj = mapper.get(2L);
		return obj;
	}

	public List<User> list() {
		List<User> list = mapper.list();
		return list;
	}

}
