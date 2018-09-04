package com.lixiaozhuo._05_scope;

public class SomeBean {
	public SomeBean(){
		System.out.println("SomeBean.SomeBean()");
	}
	
	public void init(){
		System.out.println("SomeBean.init()");
	}
	
	public void destroy(){
		System.out.println("SomeBean.destroy()");
	}
}
