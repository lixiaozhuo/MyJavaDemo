package com.lixiaozhuo._01_list;

import java.util.ArrayDeque;
import java.util.Stack;

//栈
public class StackDemo {
	public static void main(String[] args) {
		Stack<String> s1 = new Stack<>();
		s1.add("c");
		s1.add("b");
		s1.push("123");
		System.out.println(s1.pop());
		System.out.println(s1);
		
		ArrayDeque<String> s2 = new ArrayDeque<>();
		s2.push("c");
		s2.push("s");
		System.out.println(s2);

	}
}
