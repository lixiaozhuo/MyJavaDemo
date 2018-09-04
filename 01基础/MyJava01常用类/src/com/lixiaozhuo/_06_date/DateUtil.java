package com.lixiaozhuo._06_date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.lixiaozhuo._04_char_sequence.StringUtil;

//Data工具类
public class DateUtil {
	//默认格式化
	public static final String DEFAULT_DATE_PATTERN = "yyyy-HH-dd HH:mm:ss";

	private DateUtil() {
	}

	public static void main(String[] args) {
		System.out.println(dateToString(new Date(), "yyyy-HH-dd HH:mm:ss"));
		System.out.println(dateToString(new Date(), "yyyy/HH/dd HH:mm:ss"));
		System.out.println(dateToString(new Date(), "YYYY/HH/dd"));
		System.out.println(dateToString(new Date(), null));
	}

	//时间转换字符串
	public static String dateToString(Date date) {
		return dateToString(date, null);
	}

	//时间转换字符串
	public static String dateToString(Date date, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat();
		if (StringUtil.isBank(pattern)) {
			pattern = DEFAULT_DATE_PATTERN;//默认格式
		}
		sdf.applyPattern(pattern);//设置格式化格式
		return sdf.format(date);//格式化时间
	}

	//字符串转换时间
	public static Date stringToDate(String date) throws ParseException {
		return stringToDate(date, null);
	}

	//字符串转换时间
	public static Date stringToDate(String date, String pattern) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat();
		if (StringUtil.isBank(pattern)) {
			pattern = DEFAULT_DATE_PATTERN;//默认格式
		}
		sdf.applyPattern(pattern);//设置格式化格式
		return sdf.parse(date);//解析字符串
	}

}
