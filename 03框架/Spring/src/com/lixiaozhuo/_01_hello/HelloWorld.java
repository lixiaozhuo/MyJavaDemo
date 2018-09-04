package com.lixiaozhuo._01_hello;

import lombok.Setter;

public class HelloWorld {
	
	@Setter
	private String value;
	
	public void sayHello(){
		System.out.println("hello->" + value);
	}
}
