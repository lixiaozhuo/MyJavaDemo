package com.lixiaozhuo.mapper;

import java.util.List;

import com.lixiaozhuo.domain.User;

public interface UserMapper {

	void add(User obj);

	void update(User obj);

	void delete(Long id);

	User get(Long id);

	List<User> list();
}
