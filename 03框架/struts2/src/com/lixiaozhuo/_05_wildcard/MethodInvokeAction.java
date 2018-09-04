package com.lixiaozhuo._05_wildcard;

import com.opensymphony.xwork2.ActionSupport;

//方法调用测试
public class MethodInvokeAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	
	@Override
	public String execute() throws Exception {
		System.out.println("MehodsInvokeAction.execute()");
		return NONE;
	}
	
	public String save() throws Exception {
		System.out.println("MehodsInvokeAction.save()");
		return NONE;
	}
	
	public String delete() throws Exception {
		System.out.println("MehodsInvokeAction.delete()");
		return NONE;
	}

}
