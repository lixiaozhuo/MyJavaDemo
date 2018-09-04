package com.lixiaozhuo._01_logon.template;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.lixiaozhuo._01_logon.handler.IResultSetHandler;
import com.lixiaozhuo._01_logon.utils.DBCPUtil;

public class jdbcTemplate {
	private jdbcTemplate() {
	};

	/**
	 * DML模板
	 * @param sql sql语句
	 * @param params 参数
	 * @return 执行结果
	 */
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

	/**
	 * DQL模板
	 * @param sql sql语句
	 * @param rsh 结果集处理
	 * @param params 参数
	 * @return 查询结果
	 */
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
