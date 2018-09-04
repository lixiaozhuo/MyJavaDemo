package com.lixiaozhuo._06_di.simple;

import java.net.URL;

import lombok.Setter;
import lombok.ToString;

@Setter@ToString
public class Employee {
	private String name;
	private Integer age;
	private Double salary;
	private URL url;
	public Employee(String name, Integer age, Double salary, URL url) {
		super();
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.url = url;
	}
}
