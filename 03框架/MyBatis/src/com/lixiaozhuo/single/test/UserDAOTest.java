package com.lixiaozhuo.single.test;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.lixiaozhuo.single.domain.User;
import com.lixiaozhuo.single.page.PageResult;
import com.lixiaozhuo.single.query.UserQuery;
import com.lixiaozhuo.single.service.IUserService;
import com.lixiaozhuo.single.service.impl.UserServiceImpl;

import lombok.Setter;

public class UserDAOTest {

	@Setter
	IUserService service = new UserServiceImpl();

	@Test
	public void testSave() {
		User obj = new User();
		obj.setUsername("aaa");
		obj.setPassword("admin");
		obj.setAge(18);
		service.save(obj);
	}

	@Test
	public void testUpdate() {
		User obj = new User();
		obj.setId(2L);
		obj.setUsername("ddd");
		obj.setPassword("admin");
		obj.setAge(28);
		service.update(obj);
	}

	@Test
	public void testDelete() {
		service.delete(1L);
	}

	@Test
	public void testGet() {
		User obj = service.get(2L);
		System.out.println(obj);
	}

	@Test
	public void testListAll() {
		List<User> list = service.list();
		for (User user : list) {
			System.out.println(user);
		}
	}

	@Test
	public void testQueryByConditon() {
		UserQuery qo = new UserQuery();
		qo.setKeyword("aaa");
		qo.setBeginAge(18);
		qo.setEndAge(28);

		List<User> list = service.queryByConditon(qo);
		for (User user : list) {
			System.out.println(user);
		}
	}

	@Test
	public void testQueryByAge() {
		List<User> list = service.queryByAge(Arrays.asList(18, 19));
		for (User user : list) {
			System.out.println(user);
		}
	}
	
	@Test
	public void testQuery() {
		UserQuery qo = new UserQuery();
		qo.setKeyword("aaa");
		qo.setBeginAge(18);
		qo.setEndAge(28);
		qo.setCurrentPage(3);
		qo.setPageSize(3);		
		PageResult<User> result = service.query(qo);
		System.out.println(result);
	}
	
	@Test
	public void testCheckLogin() {	
		User obj = service.checkLogin("aa", "bb");
		System.out.println(obj);
	}
}
