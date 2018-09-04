package com.lixiaozhuo._05_session;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter@Setter
@ToString
public class Person {
	private Long id;
	private String name;
	private BigDecimal salary;
	private Date hiredate;


	
}
