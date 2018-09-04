package com.lixiaozhuo._06_date;

import java.util.Date;

//Data类
public class DateDemo {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		Date date = new Date();
		System.out.println(date);
		
		System.out.println(date.getTime());
		
		System.out.println(date.toLocaleString());//本地格式时间
	}
}
