package com.lixiaozhuo.smis.handler;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BeanListHandler<T> implements IResultSetHandler<List<T>> {

	private Class<T> type;

	public BeanListHandler(Class<T> type) {
		this.type = type;
	}

	@Override
	public List<T> handler(ResultSet rs) {
		List<T> list = new ArrayList<>();
		try {		
			BeanInfo beanInfo = Introspector.getBeanInfo(type, Object.class);
			PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
			while (rs.next()) {
				// 传递进的类型创建对象
				T obj = type.newInstance();
				// 结果集封装进obj对象
				for (PropertyDescriptor pd : pds) {
					// 使用内省机制操作JavaBean中的属性
					// 根据属性名称从结果集取出数据,设置给对应的属性,(列名称=属性名称)
					pd.getWriteMethod().invoke(obj, rs.getObject(pd.getName()));
				}
				list.add(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
