package com.lixiaozhuo._13_query.domain;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class Phone {
	@Override
	public String toString() {
		return "Phone [id=" + id + ", types=" + types + ", number=" + number
				+ "]";
	}
	private Long id;
	private String types;//电话类型:工作/私人
	private String number;//电话号码
	//many2one 多个电话可以属于同一个员工
	private Employee employee;
}
