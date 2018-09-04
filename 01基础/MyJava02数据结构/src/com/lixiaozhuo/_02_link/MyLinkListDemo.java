package com.lixiaozhuo._02_link;

//自定义链表测试
public class MyLinkListDemo {
	public static void main(String[] args) {
		MyLinkList list1 = new MyLinkList();
		list1.addLast("a");
		list1.addLast(15);
		list1.addLast(true);
		list1.remove(true);
		System.out.println(list1);
		MyLinkList list2 = new MyLinkList();
		list2.addFirst("a");
		list2.addFirst(15);
		list2.addFirst(true);
		System.out.println(list2);
	}
}
