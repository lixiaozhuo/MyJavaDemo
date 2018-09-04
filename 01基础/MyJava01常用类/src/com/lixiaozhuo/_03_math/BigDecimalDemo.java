package com.lixiaozhuo._03_math;

import java.math.BigDecimal;

//BigDecimal 
public class BigDecimalDemo {
	public static void main(String[] args) {		
		BigDecimal num1 = new BigDecimal("3.14");
		BigDecimal num2 = new BigDecimal("4.12");
		num1 = num1.add(num2);
		System.out.println("num1=" + num1);
	}
}
