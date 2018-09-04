package com.lixiaozhuo._04_bean_create.staticfactory;

public class SomeBean2Factory {
	private SomeBean2Factory(){};
	
	public static SomeBean2 getSomeBean(){
		return new SomeBean2();
	}
}
