package com.lixiaozhuo._05_smis_prepared_statement.jdbc_utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

//jdbc工具类
public class JDBCUtil {
	// 私有化,不可创建对象
	private JDBCUtil() {
	}

	// 数据库配置文件
	private static Properties properties = new Properties();
	static {
		try {
			// 读取配置文件
			InputStream inputStream = Thread.currentThread()
					.getContextClassLoader()
					.getResourceAsStream("db.properties");
			properties.load(inputStream);
			// 加载驱动
			Class.forName(properties.getProperty("driverClassName"));
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
			// 获取连接对象
			return DriverManager.getConnection(
					properties.getProperty("url"),
					properties.getProperty("user"),
					properties.getProperty("password"));

		} catch (Exception e) {
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
	public static void close(Connection conn, Statement statement, ResultSet rs) {
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (statement != null) {
			try {
				statement.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (rs != null) {
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
}
