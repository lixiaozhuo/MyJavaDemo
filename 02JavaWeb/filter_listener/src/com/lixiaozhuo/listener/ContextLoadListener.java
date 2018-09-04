package com.lixiaozhuo.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

//监听contextInitialized创建和销毁
@WebListener
public class ContextLoadListener implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("contextInitialized对象创建");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("contextInitialized对象销毁");
	}

}
