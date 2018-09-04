package com.lixiaozhuo._02_api;

import org.hibernate.Session;
import org.junit.Test;

import com.lixiaozhuo._01_crud.domain.User;
import com.lixiaozhuo.utils.HibernateUtil;

//Session对象   1级缓存机制
public class SessionTest {
	@Test
	public void test() {
		// 创建Session对象
		Session session1 = HibernateUtil.getSession();
		// 具体操作
		session1.get(User.class, 1L);
		session1.get(User.class, 1L);
		session1.close();
		// 创建Session对象
		Session session2 = HibernateUtil.getSession();
		// 具体操作
		session2.get(User.class, 1L);
		session2.get(User.class, 1L);
		session2.close();
	}
}
