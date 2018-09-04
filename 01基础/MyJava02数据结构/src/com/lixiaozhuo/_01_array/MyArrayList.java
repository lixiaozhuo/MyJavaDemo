package com.lixiaozhuo._01_array;

import java.util.Arrays;

/**
 * 基于数组的列表
 * @author LXZ
 *
 */
//自定义数组集合
public class MyArrayList {
	//存储任意类型的元素
	private Object[] elements = null;
	//数组已经存储元素个数
	private Integer size = 0;

	public MyArrayList() {
		this(10);
	}

	//1):初始化线性列表
	public MyArrayList(Integer initialCapacity) {
		if (initialCapacity < 0) {
			throw new IllegalArgumentException("容量不可小于0");
		}
		elements = new Object[initialCapacity];
	}

	//保存新的元素
	public void add(Object ele) {
		//判断和扩容
		if (size == elements.length) {
			elements = Arrays.copyOf(elements, elements.length * 2);
		}
		elements[size] = ele;
		size++;
	}

	//查询指定索引位置元素
	public Object get(Integer index) {
		if (index < 0 || index >= size) {
			throw new IllegalArgumentException("索引越界");
		}
		return elements[index];
	}

	//替换指定索引位置元素
	public void set(Integer index, Object newEle) {
		if (index < 0 || index >= size) {
			throw new IllegalArgumentException("索引越界");
		}
		elements[index] = newEle;
	}

	//删除指定索引位置元素
	public void delete(Integer index) {
		if (index < 0 || index >= size) {
			throw new IllegalArgumentException("索引越界");
		}
		for (int i = index; i < size - 1; i++) {
			elements[i] = elements[i + 1];
		}
		elements[size - 1] = null;
		size--;
	}

	public String toString() {
		if (elements == null) {
			return "null";
		}
		if (size == 0) {
			return "[]";
		}
		StringBuilder strb = new StringBuilder(size * 2 + 1);
		strb.append("[");
		for (int i = 0; i < size; i++) {
			strb.append(elements[i]);
			if (i == size - 1) {
				strb.append("]");
			} else {
				strb.append(",");
			}
		}
		return strb.toString();
	}

	//返回数组元素个数
	public int size() {
		return size;
	}

	//判断数组中元素个数是否为0
	public boolean isEmpty() {
		return size == 0;
	}

	//清空数组元素
	public void clear() {
		for (int i = 0; i < size; i++) {
			elements[i] = null;
		}
		size = 0;
	}
}
