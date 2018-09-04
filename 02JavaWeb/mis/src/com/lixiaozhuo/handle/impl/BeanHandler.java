package com.lixiaozhuo.handle.impl;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.sql.ResultSet;

import com.lixiaozhuo.handle.IResultSetHandler;

//单条数据结果处理
public class BeanHandler<T> implements IResultSetHandler<T> {

	private Class<T> type;

	public BeanHandler(Class<T> type) {
		this.type = type;
	}

	@Override
	public T handler(ResultSet rs) {
		try {
			BeanInfo beanInfo = Introspector.getBeanInfo(type, Object.class);
			PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
			if (rs.next()) {
				// 传递进的类型创建对象
				T obj = type.newInstance();
				// 结果集封装进obj对象
				for (PropertyDescriptor pd : pds) {
					// 使用内省机制操作JavaBean中的属性
					// 根据属性名称从结果集取出数据,设置给对应的属性,(列名称=属性名称)
					pd.getWriteMethod().invoke(obj, rs.getObject(pd.getName()));
				}
				return obj;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
