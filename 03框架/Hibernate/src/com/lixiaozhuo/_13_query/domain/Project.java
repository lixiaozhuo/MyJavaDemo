package com.lixiaozhuo._13_query.domain;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Project {
	@Override
	public String toString() {
		return "Project [id=" + id + ", name=" + name + "]";
	}

	private Long id;
	private String name;
	// many2one 多个项目属于同一个经理
	private Employee manager;

	//一个项目有多个员工参与开发
	//一个员工可以开发多个项目
	private List<Employee> emps = new ArrayList<>();
}
