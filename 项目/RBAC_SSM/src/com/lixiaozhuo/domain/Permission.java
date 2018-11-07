package com.lixiaozhuo.domain;

import lombok.Getter;
import lombok.Setter;

//权限对象
@Setter
@Getter
public class Permission extends BaseDomain {
	@Override
	public String toString() {
		return "Permission [getId()=" + getId() + ", name=" + name
				+ ", expression=" + expression + "]";
	}
	private String name;
	private String expression;// 权限表达式
}
