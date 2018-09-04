package com.lixiaozhuo._01_crud.domain;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class User {
	private Long id;
	private String name;
	private BigDecimal salary;
	private Date hiredate;
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", salary=" + salary
				+ ", hiredate=" + hiredate + "]";
	}
	
}
