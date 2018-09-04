package com.lixiaozhuo._13_smis_hibernate.handler;

import java.sql.ResultSet;

//返回值处理接口
public interface IResultSetHandler<T> {
	T handler(ResultSet rs);
}
