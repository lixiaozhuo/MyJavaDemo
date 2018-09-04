package com.lixiaozhuo._07_regex;

//正则表达式
public class RegexDemo {
	public static void main(String[] args) {
		//判断是否为数字
		System.out.print("是否为数字:");
		System.out.println("55".matches("\\d+"));

		//判断是否为手机号码
		String input = "18730291527";
		String regex = "^[1][3|5|7|8|9]\\d{9}$";
		System.out.print("是否为手机号码:");
		System.out.println(input.matches(regex));
		//判断是否为身份证号
		input = "13058219970708201x";
		regex = "\\d{17}[X|x|\\d]$";
		System.out.print("是否为身份证号:");
		System.out.println(input.matches(regex));

	}

}
