package com.lixiaozhuo.many2one.domain;

import lombok.Getter;
import lombok.Setter;

//员工表
@Getter
@Setter
public class Employee {
	private Long id;
	private String username;
	private Department dept;
	@Override
	public String toString() {
		return "Employee [id=" + id + ", username=" + username + "]" ;
	}
	
}
