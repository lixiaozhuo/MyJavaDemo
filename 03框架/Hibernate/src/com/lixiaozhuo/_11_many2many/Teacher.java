package com.lixiaozhuo._11_many2many;

import java.util.HashSet;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class Teacher {
	private Long id;
	private String name;
	private Set<Student> student = new HashSet<>();
}
