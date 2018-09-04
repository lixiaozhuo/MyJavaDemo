package com.lixiaozhuo._03_method;

import java.lang.reflect.Method;
import java.util.Arrays;

class Empoyee {
	public static void doWork1(int... arr) {
		System.out.println("调用" + Arrays.toString(arr));
	}

	public static void doWork2(String... arr) {
		System.out.println("调用" + Arrays.toString(arr));
	}
}

//数组参数的方法实现
public class ArrayMethodInvokeDemo1 {
	public static void main(String[] args) throws Exception {
		Class<Empoyee> clz = Empoyee.class;
		//情况1:数组的元素类型是基本类型
		Method method = clz.getMethod("doWork1", int[].class);
		System.out.println(method);
		method.invoke(null, new Object[] {new int[] { 1, 2, 3, 4, 5 }});
		//情况2:数组的元素类型是引用类型
		method = clz.getMethod("doWork2", String[].class);
		System.out.println(method);
		//调用静态方法,对象直接为null
		method.invoke(null, new Object[] { new String[] { "a", "b" } });
		
		
	}
}
