package com.lixiaozhuo.many2one.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//部门表
@Getter
@Setter
@ToString
//@Alias("Department")
public class Department {
	private Long id;
	private String name;
}
