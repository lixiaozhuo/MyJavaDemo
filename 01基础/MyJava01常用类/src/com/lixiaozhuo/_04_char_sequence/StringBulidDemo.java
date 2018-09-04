package com.lixiaozhuo._04_char_sequence;

//StringBuilder常用方法
public class StringBulidDemo {
	public static void main(String[] args) {
		//append:字符串追加到此序列
		StringBuilder str1 = new StringBuilder();//等价于 new StringBuildr(16)
		str1.append("").append("aa");//链式拼接
		System.out.println("str1=" + str1);

		StringBuilder str2 = str1.append("b");
		System.out.println("str2=" + str2);
		
		//deleteCharAt: 移除此序列指定位置上的 char
		String str3 = "ABCDEF";
		System.out.println(new StringBuilder(str3).deleteCharAt(str3.length() - 1).toString());
		
		//reverse:将此字符序列用其反转形式取代。
		System.out.println(new StringBuilder(str3).reverse());
	}
}
