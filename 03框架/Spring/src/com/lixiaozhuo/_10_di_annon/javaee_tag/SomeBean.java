package com.lixiaozhuo._10_di_annon.javaee_tag;

import javax.annotation.Resource;

import lombok.ToString;

@ToString
public class SomeBean {
	@Resource
	private OtherBean1 otherBean1;
	@Resource(name="otherBean2")
	private OtherBean2 otherBean2;
}
