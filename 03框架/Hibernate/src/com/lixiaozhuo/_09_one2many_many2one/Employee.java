package com.lixiaozhuo._09_one2many_many2one;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//员工表
@Getter
@Setter
@ToString
public class Employee {
	private Long id;
	private String name;
	private Department depa;
}
