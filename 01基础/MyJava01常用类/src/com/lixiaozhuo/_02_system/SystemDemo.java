package com.lixiaozhuo._02_system;

import java.util.Arrays;

//System
public class SystemDemo {
	public static void main(String[] args) {
		//数组复制
		//public static void arraycopy(Object src,int srcPos,Object dest,int destPos,int length)
		int[] src = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int[] dest = new int[10];
		System.out.println("复制前数组:" + Arrays.toString(dest));
		System.arraycopy(src, 3, dest, 4, 5);
		System.out.println("复制后数组:" + Arrays.toString(dest));

		//返回以毫秒为单位的当前时间
		//public static long currentTimeMillis()
		long time = System.currentTimeMillis();//
		System.out.println("当前时间:" + time);

		//终止jvm
		//public static void exit(int status)
		System.exit(0);

		//运行垃圾回器
		//public static void gc()
		System.gc();

	}
}
