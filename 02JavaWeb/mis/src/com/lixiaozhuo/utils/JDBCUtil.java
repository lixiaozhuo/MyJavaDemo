package com.lixiaozhuo.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

//JDBC工具类
public class JDBCUtil {
	// 私有化,不可创建对象
	private JDBCUtil() {
	}

	// 数据库配置文件
	private static Properties properties = new Properties();
	private static DataSource ds;
	static {
		// 读取配置文件
		try (InputStream inputStream = Thread.currentThread()
				.getContextClassLoader()
				.getResourceAsStream("db.properties");) {
			properties.load(inputStream);
			ds = DruidDataSourceFactory.createDataSource(properties);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取Connection对象
	 * 
	 * @return Connection对象,创建失败返回null
	 */
	public static Connection getConnection() {
		try {
			return ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 关闭对象,释放资源
	 * 
	 * @param conn
	 *            Connecton连接对象
	 * @param statement
	 *            statement数据对象
	 * @param rs
	 *            结果集对象
	 */
	public static void close(Connection conn, Statement statement,
			ResultSet rs) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
			}
		}
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
