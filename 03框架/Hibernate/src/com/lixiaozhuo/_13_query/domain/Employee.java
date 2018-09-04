package com.lixiaozhuo._13_query.domain;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

//员工
@Getter@Setter
public class Employee {
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary
				+ ", hireDate=" + hireDate + "]";
	}

	private Long id;
	private String name;
	private BigDecimal salary;
	private Date hireDate;
	
	//many2one 多个员工对应同一个部门
	private Department dept;
}
