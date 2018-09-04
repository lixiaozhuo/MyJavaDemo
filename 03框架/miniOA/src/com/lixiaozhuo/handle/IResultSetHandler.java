package com.lixiaozhuo.handle;

import java.sql.ResultSet;

//返回值处理接口
public interface IResultSetHandler<T> {
	/**
	 * 处理返回值
	 * 
	 * @param rs
	 *            返回值集合
	 * @return 处理后结果
	 */
	T handler(ResultSet rs);

}
