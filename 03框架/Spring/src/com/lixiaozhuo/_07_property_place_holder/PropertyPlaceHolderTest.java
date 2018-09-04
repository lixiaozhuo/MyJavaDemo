package com.lixiaozhuo._07_property_place_holder;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class PropertyPlaceHolderTest {
	@Autowired
	private DataSource ds;

	// 连接数据库插入一条数据
	@Test
	public void testName() throws Exception {
		Connection conn = ds.getConnection();
		PreparedStatement statement = conn
				.prepareStatement("INSERT INTO tb_user(username) VALUES(?)");
		statement.setString(1, "aaa");
		statement.execute();
		conn.close();

	}
}
