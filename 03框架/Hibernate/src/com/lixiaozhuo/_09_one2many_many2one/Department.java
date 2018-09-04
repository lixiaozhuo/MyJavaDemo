package com.lixiaozhuo._09_one2many_many2one;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//部门表
@Getter
@Setter
@ToString
public class Department {
	private Long id;
	private String name;
	private List<Employee> em = new ArrayList<>();
}
