package com.lixiaozhuo._05_array;

import java.lang.reflect.Array;
import java.util.Arrays;

//实现任意类型数组的拷贝操作
public class ArrayDemo {
	public static void main(String[] args) {
		Object arr = new int[] { 1, 2, 3, 4, 5, 6 };
		//设置arr数组中所有为2的新元素为100
		Array.set(arr, 2, 100);
		//获取arr数组中索引为2的元素
		int val = Array.getInt(arr, 2);
		System.out.println("索引为2元素为: " + val);

		int[] src = new int[] {1,2,3,4,5,6,7,8};
		int[] dest = new int[10];
		arrayCopy(src, 2, dest, 2, 5);
		System.out.println(Arrays.toString(dest));

	}

	public static void arrayCopy(Object src, int srcPos, Object dest, int destPos, int length) {
		if (src == null || dest == null) {
			throw new NullPointerException("源数组和目标数组不可为空");
		}
		if (!src.getClass().isArray() || !dest.getClass().isArray()) {
			throw new ArrayStoreException("源和目标必须是数组");
		}
		if (srcPos < 0 || destPos < 0 || length < 0 || srcPos + length > Array.getLength(src)
				|| destPos + length > Array.getLength(dest)) {
			throw new IndexOutOfBoundsException("索引越界");
		}
		if (src.getClass().getComponentType() != dest.getClass().getComponentType()) {
			throw new ArrayStoreException("源和目标元素类型必须相同");
		}
		//需要拷贝的元素
		for(int index = srcPos ; index < srcPos +length; index++){
			//需要拷贝的元素
			Object val = Array.get(src, index);
			//给目标数组设置元素
			Array.set(dest, destPos, val);
			destPos++;
		}

	}
}
