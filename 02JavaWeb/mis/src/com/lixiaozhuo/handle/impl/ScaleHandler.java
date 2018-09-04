package com.lixiaozhuo.handle.impl;

import java.sql.ResultSet;

import com.lixiaozhuo.handle.IResultSetHandler;

//单个数据结果处理
@SuppressWarnings("all")
public class ScaleHandler<T> implements IResultSetHandler<T>{
	
	@Override
	public T handler(ResultSet rs) {
		T obj = null;
		try {
			if(rs.next()){
				obj = (T) rs.getObject(1);
			}
		} catch (Exception e) {

		}
		return obj;
	}
	
}
