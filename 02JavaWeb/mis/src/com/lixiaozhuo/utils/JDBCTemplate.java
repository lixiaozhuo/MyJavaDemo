package com.lixiaozhuo.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.lixiaozhuo.handle.IResultSetHandler;

//JDBC操作模板类
public class JDBCTemplate {
	private JDBCTemplate() {
	};

	/**
	 * DML模板
	 * 
	 * @param sql
	 *            sql语句
	 * @param params
	 *            参数
	 * @return 执行结果
	 */
	public static int update(String sql, Object... params) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = JDBCUtil.getConnection();
			ps = conn.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				ps.setObject(i + 1, params[i]);
			}
			return ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, ps, null);
		}
		return 0;
	}

	/**
	 * DQL模板
	 * 
	 * @param sql
	 *            sql语句
	 * @param rsh
	 *            结果集处理
	 * @param params
	 *            参数
	 * @return 查询结果
	 */
	public static <T> T query(IResultSetHandler<T> handler, String sql,
			Object... params) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtil.getConnection();
			ps = conn.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				ps.setObject(i + 1, params[i]);
			}
			rs = ps.executeQuery();
			return handler.handler(rs);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, ps, rs);
		}
		return null;
	}

}
