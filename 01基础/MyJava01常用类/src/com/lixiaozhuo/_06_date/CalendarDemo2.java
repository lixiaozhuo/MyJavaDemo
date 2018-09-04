package com.lixiaozhuo._06_date;

import java.util.Calendar;
import java.util.Date;

//Calendar日历类练习:表示最近的一周
public class CalendarDemo2 {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		Date current = new Date();//当前系统时间	
		//设置日历时间为当前系统时间
		Calendar c = Calendar.getInstance();
		c.setTime(current);
		//把日增加一天,在把时分秒设置为0
		c.add(Calendar.DAY_OF_MONTH, 1);//把时增加一天
		c.set(Calendar.HOUR_OF_DAY, 0);//把分设置为0
		c.set(Calendar.MINUTE, 0);//把分设置为0
		c.set(Calendar.SECOND, 0);//把秒设置为0

		Date endDate = c.getTime();//结束时间
		c.add(Calendar.DAY_OF_MONTH, -7);
		Date beginDate = c.getTime();//开始时间

		System.out.println(beginDate.toLocaleString());
		System.out.println(endDate.toLocaleString());
	}
}
