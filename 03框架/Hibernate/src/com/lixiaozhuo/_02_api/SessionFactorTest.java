package com.lixiaozhuo._02_api;

import org.hibernate.Session;
import org.junit.Test;

import com.lixiaozhuo._01_crud.domain.User;
import com.lixiaozhuo.utils.HibernateUtil;

//SessionFactor对象 抽取Hibernate工具类
//针对一个应用,一个数据库服务器,只需要一个SessionFactory实例就够了
public class SessionFactorTest {
	@Test
	public void test() {
		// 创建Session对象
		Session session = HibernateUtil.getSession();
		// 具体操作
		session.beginTransaction();
		User user =  session.get(User.class, 1L);
		session.getTransaction().commit();
		// 关闭Session对象
		session.close();
		System.out.println(user);
	}
}
