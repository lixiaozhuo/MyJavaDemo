package com.lixiaozhuo._10_di_annon.spring_tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import lombok.ToString;

@ToString
public class SomeBean {
	@Autowired(required=false)//找不到对象则为空 默认为true
	@Qualifier("otherBean1")//限制依赖对象的id属性
	private OtherBean1 otherBean1;
	@Autowired
	private OtherBean2 otherBean2;
}
