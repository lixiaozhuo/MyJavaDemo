package com.lixiaozhuo._01_list;

import java.util.Arrays;
import java.util.Vector;

//Vector类:数组
public class VectorDemo {
	public static void main(String[] args) {
		// addTest();
		deleteTest();
		//setTest();
		//selectTest();
	}

	// 增加:
	// boolean add(Object e) 将指定元素添加到此向量的末尾,等价于addElement方法。
	// void add(int index, Object element) 在此向量的指定位置插入指定的元素。
	// boolean addAll(Collection c) :把c集合中的元素添加到当前集合对象中.
	public static void addTest() {

		Vector<String> v1 = new Vector<>(5);
		v1.add("a");// 将指定元素添加到此向量的末尾。
		v1.add("b");
		v1.add("c");
		System.out.println(v1);

		v1.add(0, "0");// 在此向量的指定位置插入指定的元素。
		System.out.println(v1);

		Vector<Object> v2 = new Vector<>();
		v2.add(1);
		v2.add(2);
		v2.add(v1);
		v2.addAll(v1);// 将指定 Collection 中的所有元素添加到此向量的末尾，按照指定 collection
						// 的迭代器所返回的顺序添加这些元素
		System.out.println(v2);

		// 集合框架存储的是对象的引用,
		StringBuilder str = new StringBuilder();
		v2.add(str);
		System.out.println(v2);
		str.append("aaa");
		System.out.println(v2);
	}

	// 删除:
	// Object remove(int index) :删除指定索引位置的元素,并返回删除之后的元素.
	// boolean remove(Object o):删除指定的元素.
	// boolean removeAll(Collection c):从此集合中移除包含在指定 集合c中的所有元素。
	// boolean retainAll(Collection c):在此集合中仅保留包含在指定 集合c中的元素,求两个集合的交集。
	public static void deleteTest() {
		Vector<String> v1 = new Vector<>(5);
		v1.add("a");
		v1.add("b");
		v1.add("c");
		v1.add("d");
		v1.remove(0);
		v1.remove("b");
		System.out.println(v1);
		Vector<Object> v2 = new Vector<>();
		v2.add("a");
		v2.add("d");
		v1.removeAll(v2);
		System.out.println(v1);
		v1.retainAll(v2);
		System.out.println(v1);
	}

	// 修改:
	// Object set(int index, Object element) :
	// 修改当前集合中指定索引位置的元素.返回被替换的旧的元素.
	public static void setTest() {
		Vector<String> v1 = new Vector<>(5);
		v1.add("a");
		v1.add("b");
		v1.add("c");
		v1.set(2, "d");
		System.out.println(v1);
	}
	
	// 查询:
	// int size() :返回当前集合中存储几个元素.
	// boolean isEmpty():判断当前集合中元素个数是否为0.
	// Object get(int index):查询指定索引位置的元素.
	// Object[] toArray():把集合对象转换为Object数组.
	public static void selectTest(){
		Vector<String> v1 = new Vector<>(5);
		v1.add("a");
		v1.add("b");
		v1.add("c");
		System.out.println(v1.size());
		System.out.println(v1.get(1));
		System.out.println(v1.isEmpty());
		Object[] strs = v1.toArray();
		System.out.println(Arrays.toString(strs));
	}

}
