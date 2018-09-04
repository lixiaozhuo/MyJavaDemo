package com.lixiaozhuo._02_DDL_DML_DQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import org.junit.Test;

//JDBC执行DDL语句
public class DDLTest {
	@Test
	public void testCreate() throws Exception {
		// 加载注册驱动
		Class.forName("com.mysql.jdbc.Driver");

		// 获取连接对象
		Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/myjdbc", "root", "admin");
		// 创建语句对象
		Statement statement = conn.createStatement();
		// 执行SQL语句
		statement.executeUpdate(
				"CREATE TABLE mytable( id BIGINT PRIMARY KEY AUTO_INCREMENT,"
						+ "name VARCHAR(10)," + "age INT " + ")");
		// 释放资源
		statement.close();
		conn.close();
	}
}
