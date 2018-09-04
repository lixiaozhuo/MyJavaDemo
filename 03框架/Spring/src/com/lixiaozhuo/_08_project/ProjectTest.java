package com.lixiaozhuo._08_project;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lixiaozhuo._08_project.domain.User;
import com.lixiaozhuo._08_project.web.action.UserAction;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
//简单的项目流程(XML配置方式)
public class ProjectTest {
	@Autowired
	private ApplicationContext context;

	@Test
	public void testName() throws Exception {
		UserAction bean = context.getBean("userAction",UserAction.class);
		bean.save(new User());
	}
}
