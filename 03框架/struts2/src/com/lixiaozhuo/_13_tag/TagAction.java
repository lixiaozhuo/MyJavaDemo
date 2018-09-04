package com.lixiaozhuo._13_tag;

import java.util.ArrayList;
import java.util.List;

import com.lixiaozhuo._07_parm.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class TagAction extends ActionSupport {


	private static final long serialVersionUID = 1L;

	@Override
	public String execute() throws Exception {
		
		User user1 = new User("aaa","18");
		User user2 = new User("bbb","18");
		User user3 = new User("bbb","18");
		List<User> list = new ArrayList<>();
		list.add(user1);
		list.add(user2);
		list.add(user3);
		
		ActionContext.getContext().put("list",list);
		ActionContext.getContext().put("age","20");
		
		return SUCCESS;
	}

}
