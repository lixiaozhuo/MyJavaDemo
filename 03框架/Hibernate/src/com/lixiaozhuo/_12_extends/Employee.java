package com.lixiaozhuo._12_extends;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class Employee extends User{
	private BigDecimal salary;
}
