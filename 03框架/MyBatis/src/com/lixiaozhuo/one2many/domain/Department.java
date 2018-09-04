package com.lixiaozhuo.one2many.domain;

import java.util.ArrayList;
import java.util.List;

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
	private List<Employee> emps = new ArrayList<>();
}
