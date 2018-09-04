package com.lixiaozhuo._04_char_sequence;

//String练习
public class StringDemo3 {
	public static void main(String[] args) {
		test1();
		test2();
		test3();
	}

	//获取hello开头的文件名的后缀名
	private static void test1() {
		System.out.println("---------获取hello开头的文件名的后缀名----------");
		//多个文件名称组成的一个字符串
		String fileName = "abc.java;hello.txt;hello.java;hello.class";
		//以分号来分割字符串,获取每一个文件的名称和扩展名
		String[] names = fileName.split(";");
		//遍历循环文件名
		for (String name : names) {
			//判断每一个字符串是否以hello开头
			if (name.startsWith("hello")) {
				System.out.println("hello打头的文件名:" + name);
				//获取文件名的后缀名:最后一个点的后半部分
				int index = name.lastIndexOf(".");
				System.out.println("文件后缀索引:" + index);
				//截取字符串
				String newName = name.substring(index + 1);
				System.out.println("后缀:" + newName);
			}
		}
	}

	//单词首字母大写
	private static void test2() {
		System.out.println("---------单词首字母大写----------");
		String str = "willabcdef";
		//获取第一个字符
		String first = str.substring(0, 1);
		//转换为大写
		first = first.toUpperCase();
		//除第一个字符外的其他字符
		String end = str.substring(1);
		//组成新的字符串
		String newStr = first + end;
		System.out.println("单词首字母大写: " + newStr);
	}

	//判断字符串是否非空
	private static void test3() {
		System.out.println("---------判断字符串是否非空----------");
		String str = null;//"" " " null
		if (StringUtil.hasLength(str)) {
			System.out.println("str字符串非空");
		} else {
			System.out.println("str字符串为空");
		}
	}

}
