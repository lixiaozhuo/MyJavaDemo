package com.lixiaozhuo._01_annotation;

import java.util.ArrayList;
import java.util.List;


//系统自带注解
public class SystemAnnotation {
	@Override   //限定覆写父类方法
	@Deprecated  //标记过时数据
	public String toString(){
		return "";		
	}
	@SafeVarargs  //抑制堆污染警告
    public static <T> List<T> asList(T... a) {
		return null;
    }
	@SuppressWarnings(value = "all")//抑制编译器发出的警告
	public static void main(String[] args) {
		List list = new ArrayList();
		new SystemAnnotation().toString();
	}
}
