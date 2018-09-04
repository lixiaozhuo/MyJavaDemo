package com.lixiaozhuo._02_DDL_DML_DQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import org.junit.Test;
import lombok.Cleanup;

//JDBC执行DML语句
public class DMLTest {
	// 执行插入语句 原始出错处理
	@Test
	public void testInsert() {
		Connection conn = null;
		Statement statment = null;
		try {
			// 加载注册驱动
			Class.forName("com.mysql.jdbc.Driver");
			// 获取连接对象
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/myjdbc", "root", "admin");
			// 创建语句对象
			statment = conn.createStatement();
			// 执行SQL语句
			statment.executeUpdate(
					"INSERT INTO mytable(name,age) VALUES ('aa','19')");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 释放资源
			if (conn != null) {
				try {
					statment.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	// 执行更新语句 JAVA7出错处理
	@Test
	public void testDelete() {
		// 默认加载注册驱动
		// 获取连接对象
		try (Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/myjdbc", "root", "admin");
				// 创建语句对象
				Statement statement = conn.createStatement();) {
			// 执行SQL语句
			statement.executeUpdate("DELETE FROM mytable WHERE id = 4");
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 自动释放资源
	}

	// 执行更新语句 lombok注解处理
	@Test
	public void testUpdate() {
		// 默认加载注册驱动

		try {
			// 获取连接对象
			@Cleanup
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/myjdbc", "root", "admin");
			@Cleanup
			// 创建语句对象
			Statement statement = conn.createStatement();
			// 执行SQL语句
			statement.executeUpdate(
					"UPDATE mytable SET name = 'bbb',age = '20' WHERE id = 2");
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 自动释放资源
	}
}
