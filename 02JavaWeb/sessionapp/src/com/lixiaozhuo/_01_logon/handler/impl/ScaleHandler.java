package com.lixiaozhuo._01_logon.handler.impl;

import java.sql.ResultSet;

import com.lixiaozhuo._01_logon.handler.IResultSetHandler;

public class ScaleHandler implements IResultSetHandler<Long> {

	@Override
	public Long handler(ResultSet rs) {
		try {
			if (rs.next()) {
				return rs.getLong(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0L;
	}

}
