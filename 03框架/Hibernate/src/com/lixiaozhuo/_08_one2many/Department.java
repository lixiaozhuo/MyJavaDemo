package com.lixiaozhuo._08_one2many;

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
