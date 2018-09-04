package com.lixiaozhuo._03_generic_type;

import java.util.List;

//泛型通配符
public class GeericaTypeDemo2 {
	public static void main(String[] args) {

	}
    //泛型的上限:此时的泛型? 必须是Number类或Number类的子类
	@SuppressWarnings("unused")
	private static void doWork1(List<? extends Number> list) {

	}
	//泛型的下限:此时的泛型?必须是Number类或Number类的父类
	@SuppressWarnings("unused")
	private static void doWork2(List<? super Number> list) {

	}
}
