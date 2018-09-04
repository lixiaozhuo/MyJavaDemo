package com.lixiaozhuo._01_annotation;

import java.lang.annotation.Annotation;

//被贴的程序元素
@MyAnnotation(value = 5,value1 = "")
public class AnnotationDemo {
	public static void main(String[] args) {
		Class<?> clazz = AnnotationDemo.class;
		Annotation[] anns = clazz.getAnnotations();//获取所有注解
		for(Annotation ann : anns){
			System.out.println(ann);			
		}
		
		MyAnnotation ann = clazz.getAnnotation(MyAnnotation.class);//获取指定注解
		System.out.println(ann);
		System.out.println("value = " + ann.value() + "value1 = " + ann.value1());
	}
}
