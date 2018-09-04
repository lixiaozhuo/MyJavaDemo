package com.lixiaozhuo._13_smis_hibernate.domain;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//注解属性对应的数据库列名
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface SqlField {
	String value();
}
