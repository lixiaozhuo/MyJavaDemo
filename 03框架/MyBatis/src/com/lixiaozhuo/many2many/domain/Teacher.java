package com.lixiaozhuo.many2many.domain;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter@Setter@ToString
public class Teacher {
	private Long id;
	private String name;
	private List<Student> students = new ArrayList<>();
}
