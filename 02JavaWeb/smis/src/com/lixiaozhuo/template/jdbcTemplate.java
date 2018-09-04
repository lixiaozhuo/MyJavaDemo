package com.lixiaozhuo.template;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.lixiaozhuo.handler.IResultSetHandler;
import com.lixiaozhuo.utils.DBCPUtil;

public class jdbcTemplate {
	private jdbcTemplate() {
	};

	// DML模板
	public static int update(String sql, Object... params) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DBCPUtil.getConnection();
			ps = conn.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				ps.setObject(i + 1, params[i]);
			}
			return ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBCPUtil.close(conn, ps, null);
		}
		return 0;
	}

	// DQL模板
	public static <T> T query(String sql, IResultSetHandler<T> rsh, Object... params) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBCPUtil.getConnection();
			ps = conn.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				ps.setObject(i + 1, params[i]);
			}
			rs = ps.executeQuery();// 执行查询语句
			return rsh.handler(rs); // 处理返回值
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBCPUtil.close(conn, ps, rs);
		}
		return null;
	}
}
