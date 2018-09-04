package com.lixiaozhuo._02_DDL_DML_DQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import org.junit.Test;

//JDBC执行DQL语句
public class DQLTest {
	//查询单行数据
	@Test
	public void selectSingle() throws Exception {
		//加载注册驱动
		Class.forName("com.mysql.jdbc.Driver");
		//获取连接对象
		Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/myjdbc",
				"root",
				"admin");
		//创建语句对象
		Statement statement = conn.createStatement();
		//执行SQL语句
		ResultSet rs = statement.executeQuery(
				"SELECT id,productName,salePrice FROM product WHERE id = 10");
		if (rs.next()) {
			long id = rs.getLong("id");
			String productName = rs.getString("productName");
			int salePrice = rs.getInt("salePrice");
			System.out.println(id + "," + productName + "," + salePrice);
		}
		//释放资源
		rs.close();
		statement.close();
		conn.close();
	}
	
	
	//查询多行数据
	@Test
	public void selectAll() throws Exception {
		//加载注册驱动
		Class.forName("com.mysql.jdbc.Driver");
		//获取连接对象
		Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/myjdbc",
				"root",
				"admin");
		//创建语句对象
		Statement statement = conn.createStatement();
		//执行SQL语句
		ResultSet rs = statement.executeQuery(
				"SELECT id,productName,salePrice FROM product WHERE salePrice > 100");
		while (rs.next()) {
			long id = rs.getLong("id");
			String productName = rs.getString("productName");
			int salePrice = rs.getInt("salePrice");
			System.out.println(id + "," + productName + "," + salePrice);
		}
		//释放资源
		rs.close();
		statement.close();
		conn.close();
	}
	
	//查询数据总条数
	@Test
	public void selectCount() throws Exception {
		//加载注册驱动
		Class.forName("com.mysql.jdbc.Driver");
		//获取连接对象
		Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/myjdbc",
				"root",
				"admin");
		//创建语句对象
		Statement statement = conn.createStatement();
		//执行SQL语句
		ResultSet rs = statement.executeQuery(
				"SELECT COUNT(*) FROM product ");
		if (rs.next()) {
			long count = rs.getLong(1);
			System.out.println("count = " + count);
		}
		//释放资源
		rs.close();
		statement.close();
		conn.close();
	}
}
