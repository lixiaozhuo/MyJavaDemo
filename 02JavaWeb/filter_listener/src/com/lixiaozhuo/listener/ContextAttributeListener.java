package com.lixiaozhuo.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

//监听ServletContext参数变化监听器
public class ContextAttributeListener implements ServletContextAttributeListener{

	@Override
	public void attributeAdded(ServletContextAttributeEvent scae) {
		System.out.println("ervletContext参数增加");
	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent scae) {
		System.out.println("ervletContext参数删除");
	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent scae) {
		System.out.println("ervletContext参数更改");
	}

}
