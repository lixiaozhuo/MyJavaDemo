package com.lixiaozhuo._06_date;

import java.util.Calendar;

//Calendar日历类常用方法
public class CalendarDemo {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		System.out.println(c);
		System.out.println("年: " + c.get(Calendar.YEAR));
		System.out.println("月: " + c.get(Calendar.MONDAY));
		System.out.println("日: " + c.get(Calendar.DAY_OF_MONTH));
		System.out.println("时: " + c.get(Calendar.HOUR_OF_DAY));
		System.out.println("分: " + c.get(Calendar.MINUTE));
		System.out.println("秒: " + c.get(Calendar.SECOND));

		//Calendarת转换Date
		//Date d = c.getTime();

		//public abstract void add(int field,int amount)
		//为给定的日历字段添加或减去指定的时间量
		c.add(Calendar.DAY_OF_MONTH, 100);
		System.out.println(c.getTime().toLocaleString());
	}
}
