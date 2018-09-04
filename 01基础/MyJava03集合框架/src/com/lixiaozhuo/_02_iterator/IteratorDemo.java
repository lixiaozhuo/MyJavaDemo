package com.lixiaozhuo._02_iterator;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Vector;

//迭代元素
public class IteratorDemo {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		list.add("E");

		// 方式1：for循环
		for (int i = 0; i < list.size(); i++) {
			Object ele = list.get(i);
			System.out.println(ele);
		}

		System.out.println("---------------------------");
		// 方式2：for-each
		for (Object ele : list) {
			System.out.println(ele);
			// list.remove(ele); 底层为迭代器,应该使用迭代器进行删除
		}

		System.out.println("---------------------------");
		// 方式3:迭代器Iterator
		Iterator<String> it = list.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
			// it.remove(); 迭代器删除
		}

		System.out.println("---------------------------");
		// 方式4：使用for循环来操作迭代器Iterator
		for (Iterator<String> it2 = list.iterator(); it2.hasNext();) {
			System.out.println(it2.next());
		}

		System.out.println("---------------------------");
		Vector<String> v = new Vector<>();
		v.add("m");
		v.add("n");
		v.add("p");
		for (Iterator<String> it3 = v.iterator(); it3.hasNext();) {
			System.out.println(it3.next());
		}

		System.out.println("---------------------------");
		// 古老的迭代器,适用于Vector
		for (Enumeration<String> en = v.elements(); en.hasMoreElements();) {
			System.out.println(en.nextElement());
		}

		System.out.println("---------------------------");
		// 双向迭代器ListIterator
		for (ListIterator<String> lit = v.listIterator(); lit.hasPrevious();) {
			System.out.println("mmm");
		}

	}
}
