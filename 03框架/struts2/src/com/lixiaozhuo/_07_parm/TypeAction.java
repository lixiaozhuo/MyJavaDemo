package com.lixiaozhuo._07_parm;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import lombok.Getter;
import lombok.Setter;

//Action获取请求参数 
//方式1:Action本身作为Model对象，通过setter方法封装(属性注入)
//方式2:创建独立Model对象，页面通过ognl表达式封装(属性注入)
//方式3:使用ModelDriven接口，对请求数据进行封装(模型驱动)
public class TypeAction extends ActionSupport implements ModelDriven<User>{

	private static final long serialVersionUID = 1L;
	@Setter
	private String username;//方式1
	@Setter
	private Integer age;//方式1
	@Getter
	private User user = new User();//方式2

	@Override
	public String execute() throws Exception {
		System.out.println("Type1Action.execute()");
		System.out.println("username = " + username);
		System.out.println("age = " + age);
		System.out.println("user = " + user);
		return NONE;
	}
	
	//方式3
	@Override
	public User getModel() {		
		return user;
	}

}
