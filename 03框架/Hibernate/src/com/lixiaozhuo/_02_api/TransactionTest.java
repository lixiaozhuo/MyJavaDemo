package com.lixiaozhuo._02_api;

import org.hibernate.Session;
import org.junit.Test;

import com.lixiaozhuo.utils.HibernateUtil;

public class TransactionTest {
	//标准的处理有事务的模板代码:
	@Test
	public void testTemplate() throws Exception {
		Session session = null;
		try {
			session = HibernateUtil.getSession();
			// 开始事务状态
			session.beginTransaction();
			// 提交事务
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			// 回滚事务
			if (session != null && session.getTransaction().isActive()) {
				session.getTransaction().rollback();
			}
		}finally{
			if(session != null && session.isOpen()){
				session.close();
			}
		}

	}
}
