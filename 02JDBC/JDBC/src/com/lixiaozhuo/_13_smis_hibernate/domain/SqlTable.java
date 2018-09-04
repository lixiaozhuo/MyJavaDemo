package com.lixiaozhuo._13_smis_hibernate.domain;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//标记对应sql表名
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface SqlTable {
	String value();
}
