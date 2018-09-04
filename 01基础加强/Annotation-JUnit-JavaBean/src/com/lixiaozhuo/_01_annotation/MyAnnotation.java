package com.lixiaozhuo._01_annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//定义一个注解
//使用元注解进行限制

//@Documented  //会保存到API文档中.
//@Inherited:   //可以被子类继承到.
//表示注解可以贴在哪些位置
@Target(ElementType.TYPE)//可以贴在类,接,枚举上
//表示注解可以保存在哪一个时期
@Retention(RetentionPolicy.RUNTIME)//可以在JVM中进行获取到
public @interface MyAnnotation {
	int value();
	String value1();
	//Class<?> value2();
}
