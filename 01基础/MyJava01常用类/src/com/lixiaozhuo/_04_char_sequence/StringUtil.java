package com.lixiaozhuo._04_char_sequence;

//String工具类:判断字符串是否为空
public class StringUtil {
	private StringUtil(){}
	/**
	 * 判断字符串是否为空(为null或为空字符串)
	 * @param str 
	 * @return
	 */
	public static boolean isBank(String str) {
		return !hasLength(str);
	}
	/**
	 * 判断字符串非空(既不是空引用也不是空字符串)
	 * @param str 
	 * @return
	 */
	public  static boolean hasLength(String str) {
		return str != null && !"".equals(str.trim());
	}
}
