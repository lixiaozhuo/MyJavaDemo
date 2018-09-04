package com.lixiaozhuo._04_javabean;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;

//内省机制
public class IntrospectorDemo {
	public static void main(String[] args) throws Exception {
		//获得指定字节码对象的JavaBean信息对象
		BeanInfo beanInfo = Introspector.getBeanInfo(Person.class,Object.class);
		//获得JavaBean中所有的属性描述符
		PropertyDescriptor[] propertys = beanInfo.getPropertyDescriptors();
		for(PropertyDescriptor property : propertys){
			//获得属性描述器
			System.out.println(property);
			System.out.println("属性名字: " + property.getName());
			System.out.println("属性Get: " + property.getReadMethod());
			System.out.println("属性Set: " + property.getWriteMethod());
			System.out.println("属性类型: " + property.getPropertyType());
			System.out.println("-----------------------");
		}
		
	}
}
