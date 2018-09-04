package com.lixiaozhuo.single.service.impl;

import java.util.Collections;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.lixiaozhuo.single.domain.User;
import com.lixiaozhuo.single.mapper.UserMapper;
import com.lixiaozhuo.single.page.PageResult;
import com.lixiaozhuo.single.query.UserQuery;
import com.lixiaozhuo.single.service.IUserService;
import com.lixiaozhuo.single.utils.MyBatisUtil;

public class UserServiceImpl implements IUserService {

	@Override
	public void save(User obj) {
		SqlSession session = MyBatisUtil.getSession();
		// 执行插入
		// session.insert("com.lixiaozhuo.mapper.UserMapper.add", obj);
		UserMapper mapper = session.getMapper(UserMapper.class);
		mapper.add(obj);
		session.commit();
		session.close();
		System.out.println(obj);			
	}

	@Override
	public void update(User obj) {
		SqlSession session = MyBatisUtil.getSession();
		// 执行更新
		UserMapper mapper = session.getMapper(UserMapper.class);
		mapper.update(obj);
		session.commit();
		session.close();
		session = MyBatisUtil.getSession();
		
	}

	@Override
	public void delete(Long id) {
		SqlSession session = MyBatisUtil.getSession();
		// 执行删除
		UserMapper mapper = session.getMapper(UserMapper.class);
		mapper.delete(id);
		session.commit();
		session.close();
	}

	@Override
	public User get(Long id) {
		SqlSession session = MyBatisUtil.getSession();
		// 查询单条数据
		UserMapper mapper = session.getMapper(UserMapper.class);
		User obj = mapper.get(2L);
		session.commit();
		session.close();
		
		/*session = MyBatisUtil.getSession();
		mapper = session.getMapper(UserMapper.class);
		obj = mapper.get(obj.getId());
		session.commit();
		session.close();*/
		
		return obj;
	}

	@Override
	public List<User> list() {
		SqlSession session = MyBatisUtil.getSession();
		// 查询所有数据
		UserMapper mapper = session.getMapper(UserMapper.class);
		List<User> list = mapper.list();
		session.commit();
		session.close();
		return list;
	}

	@Override
	public List<User> queryByConditon(UserQuery qo) {
		SqlSession session = MyBatisUtil.getSession();
		// 通过高级条件查询
		UserMapper mapper = session.getMapper(UserMapper.class);
		List<User> list = mapper.queryByCondition(qo);
		session.commit();
		session.close();
		return list;
	}

	@Override
	public List<User> queryByAge(List<Integer> ages) {
		SqlSession session = MyBatisUtil.getSession();
		// 通过年龄查询
		UserMapper mapper = session.getMapper(UserMapper.class);
		List<User> list = mapper.queryByAge(ages);
		session.commit();
		session.close();
		return list;
	}

	@Override
	public PageResult<User> query(UserQuery qo) {
		SqlSession session = MyBatisUtil.getSession();
		// 查询出记录总数
		UserMapper mapper = session.getMapper(UserMapper.class);
		Long count = mapper.queryCount(qo);
		System.out.println(count);
		if (count == 0) {
			return new PageResult<User>(Collections.emptyList(), 0,
					qo.getPageSize(), qo.getCurrentPage());
		}
		// 查询数据
		List<User> data = mapper.query(qo);
		session.commit();
		session.close();
		return new PageResult<User>(data, count.intValue(), qo.getPageSize(),
				qo.getCurrentPage());
	}

	@Override
	public User checkLogin(String username, String password) {
		SqlSession session = MyBatisUtil.getSession();
		// 查询出记录总数
		UserMapper mapper = session.getMapper(UserMapper.class);
		User user = mapper.getUserByUsernameAndPassword(username, password);

		session.commit();
		session.close();
		return user;
	}

}
