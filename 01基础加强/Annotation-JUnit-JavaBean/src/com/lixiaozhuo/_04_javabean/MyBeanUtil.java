package com.lixiaozhuo._04_javabean;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.util.HashMap;
import java.util.Map;

//JavaBean和Map相互转换
public class MyBeanUtil {
	public static void main(String[] args) throws Exception {
		Map<String, Object> map = bean2map(new Person("aa", 10));
		System.out.println(map);
		Object obj = map2bean(map, Person.class);
		System.out.println(obj);
	}

	// JavaBean转换为Map
	public static Map<String, Object> bean2map(Object bean) throws Exception {
		Map<String, Object> map = new HashMap<>();
		BeanInfo beanInfo = Introspector.getBeanInfo(bean.getClass(), Object.class);
		// 获取属性描述集合
		PropertyDescriptor[] propertys = beanInfo.getPropertyDescriptors();
		for (PropertyDescriptor property : propertys) {// 遍历属性
			String key = property.getName();
			Object value = property.getReadMethod().invoke(bean);// 执行Getter获得属性值
			map.put(key, value);
		}
		return map;

	}

	// Map转换为JavaBean
	public static <T> T map2bean(Map<String, Object> beanMap, Class<T> beanType) throws Exception {
		T obj = beanType.newInstance();
		BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass(), Object.class);
		PropertyDescriptor[] propertys = beanInfo.getPropertyDescriptors();
		for (PropertyDescriptor property : propertys) {// 遍历属性
			String name = property.getName();
			Object value = beanMap.get(name);
			property.getWriteMethod().invoke(obj, value);// 执行Setter设置属性值
		}

		return obj;
	}
}
