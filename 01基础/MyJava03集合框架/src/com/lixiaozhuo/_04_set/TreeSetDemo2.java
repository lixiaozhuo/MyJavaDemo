package com.lixiaozhuo._04_set;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

//自然排序
class Person implements java.lang.Comparable<Person> {
	private String name;
	private int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String toString() {
		return "Preson(name = " + name + ",age=" + age + ")";
	}
	//自然排序
	public int compareTo(Person other) {
		if (this.age > other.age) {
			return 1;
		} else if (this.age < other.age) {
			return -1;
		}
		return 0;
	}

}

// 姓名长度比较器
class NameLengthComparator implements Comparator<Person> {
	public int compare(Person p1, Person p2) {
		if (p1.getName().length() > p2.getName().length()) {
			return 1;
		} else if (p1.getName().length() < p2.getName().length()) {
			return -1;
		} else {
			if (p1.getAge() > p2.getAge()) {
				return 1;
			} else if (p1.getAge() < p2.getAge()) {
				return -1;
			}
			return 0;
		}
	}

}

//TreeSet自然排序和定制排序
public class TreeSetDemo2 {
	public static void main(String[] args) {
		// 按照Person对象的年龄自然排序
		Set<Person> set1 = new TreeSet<>();
		set1.add(new Person("李", 20));
		set1.add(new Person("王", 30));
		set1.add(new Person("樊", 18));
		set1.add(new Person("张", 40));
		set1.add(new Person("胡", 10));
		System.out.println(set1);
		System.out.println("----------------------");
		// 按照Person对象的名字长短定制排序
		Set<Person> set2 = new TreeSet<>(new NameLengthComparator());
		set2.add(new Person("李", 20));
		set2.add(new Person("王", 30));
		set2.add(new Person("樊", 18));
		set2.add(new Person("张", 40));
		set2.add(new Person("胡", 10));
		System.out.println(set2);

	}
}
