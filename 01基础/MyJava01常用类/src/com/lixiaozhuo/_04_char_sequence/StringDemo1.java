package com.lixiaozhuo._04_char_sequence;

//String比较
public class StringDemo1 {
	private static String getString() {
		return "AB";
	}

	public static void main(String[] args) {
		String str1 = "ABCD";
		String str2 = "A" + "B" + "C" + "D";
		String str3 = "AB" + "CD";//编译优化
		String str4 = new String("ABCD");
		String temp = "AB";
		String str5 = temp + "CD";
		String str6 = getString() + "CD";
		System.out.print("ABCD==A+B+C+D: ");
		System.out.println(str1 == str2);
		System.out.print("ABCD==AB+CD: ");
		System.out.println(str1 == str3);//编译优化
		System.out.print("ABCD==new String(ABCD): ");
		System.out.println(str1 == str4);
		System.out.print("ABCD==temp+CD: ");
		System.out.println(str1 == str5);
		System.out.print("ABCD==temp+CD: ");
		System.out.println(str1 == str6);
		System.out.print("temp1+CD==temp2+CD: ");
		System.out.println(str5 == str6);
	}
}
