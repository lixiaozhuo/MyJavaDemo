package com.lixiaozhuo.domain;

import java.math.BigDecimal;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//实体类
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
	private Long id;
	private String username;
	private String password;
	private String email;
	private Date hiredate;
	private BigDecimal salary;
}
