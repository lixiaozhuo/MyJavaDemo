package com.lixiaozhuo._04_char_sequence;

import java.util.Arrays;

//String常用方法
public class StringDemo2 {

	public static void main(String[] args) {
		buildString();//字符串创建和转换
		getStringInfo();//
		stringEquals();
		toUppet();
	}

	/**
	1):String的创建和转换:
	byte[] getBytes():把字符串转换为byte数组
	char[] toCharArray():把字符串转换为char数组
	String(byte[] bytes):把byte数组转换为字符串
	String(char[] value):把char数组转换为字符串	
	 */
	
	private static void buildString() {
		System.out.println("--------字符串创建和转换----------");
		char[] ch1 = new char[] { 'a', 'b', 'c', 'd' };
		String str1 = new String(ch1);
		System.out.println("char数组转换为字符串:" + new String(ch1));
		System.out.println("字符串转换为char数组:" + str1.toCharArray().toString());
		System.out.println("byte转换为字符串:" + new String("ABCD".getBytes()));
		System.out.println("字符串转换为byte数组:" + Arrays.toString("ABCD".getBytes()));
	}

	/**
	 2):获取字符串信息
	int length() 返回此字符串的长度 
	char charAt(int index) 返回指定索引处的 char 值 
	int indexOf(String str)返回指定子字符串在此字符串中第一次出现处的索引。 
	int lastIndexOf(String str)返回指定子字符串在此字符串中最右边出现处的索引 
	 */
	private static void getStringInfo() {
		System.out.println("--------获取字符串长度----------");
		System.out.println("字符串长度:" + "ABCD E".length());
		System.out.println("索引0处值为:" + "ABCD".charAt(0));
		System.out.println("第一次出现b的索引:" + "abcd".indexOf("b"));
		System.out.println("最后一次出现b的索引:" + "abcdb".lastIndexOf("b"));
	}

	/**
	3):字符串比较判断
	boolean equals(Object anObject) 将此字符串与指定的对象比较。 
	boolean equalsIgnoreCase(String anotherString) 将此 String 与另一个 String 比较，不考虑大小写
	boolean contentEquals(CharSequence cs) 将此字符串与指定的 CharSequence 比较
	 */
	private static void stringEquals() {
		System.out.println("--------字符串比较判断----------");
		String str1 = new String("ABCD");
		String str2 = new String("ABCD");
		System.out.print("==比较:");
		System.out.println(str1 == str2);
		System.out.println("equal比较:" + str1.equals(str2));
		System.out.println("不考虑大小写比较:" + str1.equalsIgnoreCase(str2));
	}

	/**
	 4):字符串大小写转换
	String toUpperCase()  把当前字符串转换为大写(谁调用该方法,谁就是当前字符)
	String toLowerCase()  把当前字符串转换为小写
	 */
	private static void toUppet() {
		System.out.println("--------转换大小写----------");
		System.out.println("转换为大写:" + "abcd".toUpperCase());
		System.out.println("转换为小写:" + "ABCD".toLowerCase());
	}

}
