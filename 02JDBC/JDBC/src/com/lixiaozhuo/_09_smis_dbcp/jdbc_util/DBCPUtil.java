package com.lixiaozhuo._09_smis_dbcp.jdbc_util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;

//jdbc工具类
public class DBCPUtil {
	// 私有化,不可创建对象
	private DBCPUtil() {
	}

	// 数据库配置文件
	private static Properties properties = new Properties();
	private static DataSource ds = null;
	static {
		try {// 读取配置文件
			InputStream inputStream = Thread.currentThread()
					.getContextClassLoader()
					.getResourceAsStream("db.properties");
			properties.load(inputStream);
			// ds.setDriverClassName(properties.getProperty("driverClassName"));
			// ds.setUrl(properties.getProperty("url"));
			// ds.setUsername(properties.getProperty("user"));
			// ds.setPassword(properties.getProperty("password"));
			ds = BasicDataSourceFactory.createDataSource(properties);

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
			return ds.getConnection();

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
