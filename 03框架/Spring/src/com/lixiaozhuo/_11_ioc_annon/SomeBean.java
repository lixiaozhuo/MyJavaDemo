package com.lixiaozhuo._11_ioc_annon;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//<bean id="someBean" class="com.lixiaozhuo._11_ioc.SomeBean">
//默认名字为类的名字
@Component(value="someBean")
@Scope("prototype")
public class SomeBean {
	private SomeBean(){
		System.out.println("新建类");
	}
	
	@PostConstruct//初始化标签
	private void Init(){
		System.out.println("初始化资源");
	}
	
	@PreDestroy//销毁标签
	private void destroy(){
		System.out.println("销毁资源");
	}
}
