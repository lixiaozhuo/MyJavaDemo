// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   MyBeanUtil.java

package com.lixiaozhuo._04_javabean;

import java.beans.*;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.lixiaozhuo._04_javabean:
//			Person

public class MyBeanUtil
{

	public MyBeanUtil()
	{
	}

	public static void main(String args[])
		throws Exception
	{
		Map map = bean2map(new Person("aa", 10));
		System.out.println(map);
		Object obj = map2bean(map, com/lixiaozhuo/_04_javabean/Person);
		System.out.println(obj);
	}

	public static Map bean2map(Object bean)
		throws Exception
	{
		Map map = new HashMap();
		BeanInfo beanInfo = Introspector.getBeanInfo(bean.getClass(), java/lang/Object);
		PropertyDescriptor propertys[] = beanInfo.getPropertyDescriptors();
		PropertyDescriptor apropertydescriptor[];
		int j = (apropertydescriptor = propertys).length;
		for (int i = 0; i < j; i++)
		{
			PropertyDescriptor property = apropertydescriptor[i];
			String key = property.getName();
			Object value = property.getReadMethod().invoke(bean, new Object[0]);
			map.put(key, value);
		}

		return map;
	}

	public static Object map2bean(Map beanMap, Class beanType)
		throws Exception
	{
		Object obj = beanType.newInstance();
		BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass(), java/lang/Object);
		PropertyDescriptor propertys[] = beanInfo.getPropertyDescriptors();
		PropertyDescriptor apropertydescriptor[];
		int j = (apropertydescriptor = propertys).length;
		for (int i = 0; i < j; i++)
		{
			PropertyDescriptor property = apropertydescriptor[i];
			String name = property.getName();
			Object value = beanMap.get(name);
			property.getWriteMethod().invoke(obj, new Object[] {
				value
			});
		}

		return obj;
	}
}
