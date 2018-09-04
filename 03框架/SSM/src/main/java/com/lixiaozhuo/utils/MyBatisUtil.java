package com.lixiaozhuo.utils;

import java.io.IOException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {
	private MyBatisUtil() {
	}

	private static SqlSessionFactory build;
	static {
		try {
			// 获取sessionFactory
			build = new SqlSessionFactoryBuilder()
					.build(Resources.getResourceAsStream("mybatis.cfg.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static SqlSession getSession() {
		// 获取session
		return build.openSession();
	}
}
