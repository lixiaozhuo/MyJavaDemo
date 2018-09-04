package com.lixiaozhuo.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private HibernateUtil(){}
	private static SessionFactory sf = null;
	static{
		// 创建配置对象
		Configuration config = new Configuration();
		// 加载主配置文件
		config.configure("hibernate.cfg.xml");
		// 构建SessionFactory对象
		sf = config.buildSessionFactory();
	}
	
	public static Session getSession(){	
		// 创建Session对象
		 return sf.openSession();
		// return sf.getCurrentSession();
	}
	
	public static void main(String[] args) {
		
	}
}
