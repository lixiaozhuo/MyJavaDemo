package com.lixiaozhuo._06_date;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

//DataFormat类
public class DataFormatDemo {
	public static void main(String[] args) throws ParseException {
		Date date = new Date();//Tue Jul 03 17:52:00 CST 2018
		System.out.println("Data: " + date);
		DateFormat	df = DateFormat.getInstance();
		String strDate = df.format(date);//18-7-3 下午5:52
		System.out.println("格式化默认格式: " + strDate);		
		df = DateFormat.getDateInstance(DateFormat.LONG);
		strDate = df.format(date);//2018年7月3日
		System.out.println("LONG格式: " + strDate);
		df = DateFormat.getDateInstance(DateFormat.SHORT);
		strDate = df.format(date);//18-7-3
		System.out.println("SHORT格式: " + strDate);
		
		//格式化解析
		System.out.println("---------格式化解析------------");
		df = DateFormat.getInstance();
		strDate = df.format(date);
		Date date1 = df.parse(strDate);//Tue Jul 03 17:52:00 CST 2018
		System.out.println(date1);
	}

}
