package com.lixiaozhuo._21_jdbc.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter@Getter
@ToString
public class Employee {
	private Long id;
	private String name;
	private Integer age;
}
