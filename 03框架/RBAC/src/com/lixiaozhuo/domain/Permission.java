package com.lixiaozhuo.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//权限对象
@Setter
@Getter
@ToString
public class Permission extends BaseDomain {
	private String name;
	private String expression;// 权限表达式
}
