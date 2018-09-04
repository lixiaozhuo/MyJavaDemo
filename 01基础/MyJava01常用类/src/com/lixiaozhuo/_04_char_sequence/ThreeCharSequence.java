package com.lixiaozhuo._04_char_sequence;

//String StringBuilder StringBuffer拼接效率
public class ThreeCharSequence {
	public static void main(String[] args) {
		testString();
		testStringBuilder();
		testStringBuffer();
	}
	
	//String拼接30000次时间
	private static void testString() {
		long begin = System.currentTimeMillis();
		@SuppressWarnings("unused")
		String str = "";
		for (int i = 0; i < 30000; i++) {
			str += i;
		}
		long end = System.currentTimeMillis();
		System.out.print("String拼接时间:");
		System.out.println(end - begin);
	}
	
	//StringBuilder拼接30000次时间
	private static void testStringBuilder() {
		long begin = System.currentTimeMillis();
		StringBuilder str = new StringBuilder("");
		for (int i = 0; i < 30000; i++) {
			str.append(i);
		}
		long end = System.currentTimeMillis();
		System.out.print("StringBuilder拼接时间:");
		System.out.println(end - begin);
	}
	
	//StringBuffer拼接30000次时间
	private static void testStringBuffer() {
		long begin = System.currentTimeMillis();
		StringBuffer str = new StringBuffer("");
		for (int i = 0; i < 30000; i++) {
			str.append(i);
		}
		long end = System.currentTimeMillis();
		System.out.print("StringBuffer拼接时间:");
		System.out.println(end - begin);
	}
}
