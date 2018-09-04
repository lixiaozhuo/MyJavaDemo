package com.lixiaozhuo._01_connection;

import java.sql.Connection;
import java.sql.DriverManager;
import org.junit.Test;

//连接测试
public class ConnectionTest {

	@Test
	public void test() throws Exception {
		// 加载注册驱动
		Class.forName("com.mysql.jdbc.Driver");
		// 获取连接对象
		Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/myjdbc", "root", "admin");
		System.out.println(conn);
	}

}
