package com.lixiaozhuo.one2many.domain;

import lombok.Getter;
import lombok.Setter;

//员工表
@Getter
@Setter
public class Employee {
	private Long id;
	private String username;
	@Override
	public String toString() {
		return "Employee [id=" + id + ", username=" + username + "]" ;
	}
	
}
