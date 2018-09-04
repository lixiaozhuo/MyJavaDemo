package com.lixiaozhuo._06_date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//SimpleDateFormat类:是DateFormat的子类,支持自定义格式模式
public class SimpleDateFormatDemo {
	public static void main(String[] args) throws ParseException {
		String pattern="yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat sdf = new SimpleDateFormat();
		sdf.applyPattern(pattern);//申请使用哪一种时间模式
		String str= sdf.format(new Date());//格式化	
		System.out.println(str);
		//解析,使用什么风格格式化的,必须使用相同风格解析回去
		Date date = sdf.parse(str);//解析
		System.out.println(date);
		
	}
}
