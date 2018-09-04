package com.lixiaozhuo._12_smis_handler.handler;

import java.sql.ResultSet;

//返回值处理接口
public interface IResultSetHandler<T> {
	T handler(ResultSet rs);
}
