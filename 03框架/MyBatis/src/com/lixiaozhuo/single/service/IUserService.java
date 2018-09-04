package com.lixiaozhuo.single.service;

import java.util.List;

import com.lixiaozhuo.single.domain.User;
import com.lixiaozhuo.single.page.PageResult;
import com.lixiaozhuo.single.query.UserQuery;

public interface IUserService {
	void save(User obj);
	
	void update(User obj);
	
	void delete(Long id);
	
	User get(Long id);
	
	List<User> list();
	
	List<User> queryByConditon(UserQuery qo);
	
	List<User> queryByAge(List<Integer> ages);
	
	PageResult<User> query(UserQuery qo);
	
	User checkLogin(String username,String password);
}
