package com.lixiaozhuo._08_batch;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import org.junit.Test;
import com.lixiaozhuo._05_smis_prepared_statement.jdbc_utils.JDBCUtil;

//批处理
public class BatchTest {
	// Statement方式
	@Test
	public void testInsertByStatementBatch() throws Exception {
		Connection conn = JDBCUtil.getConnection();
		String sql = "";
		Statement statement = conn.createStatement();
		for (int i = 0; i <= 1000; i++) {
			sql = "INSERT INTO tb_student(name,age) VALUES ('王" + i + "',18)";
			statement.addBatch(sql);// 添加到批量处理中
			if (i % 200 == 0) {
				statement.executeBatch();// 执行批量操作
				statement.clearBatch();// 清楚批量处理中的操作
			}
		}
	}

	// PreparedStatement方式
	@Test
	public void testInsertByPreparedStatementBatch() throws Exception {
		Connection conn = JDBCUtil.getConnection();
		String sql = "INSERT INTO tb_student(name,age) VALUES (?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		for (int i = 0; i <= 1000; i++) {
			ps.setString(1, "王" + i);
			ps.setInt(2, 18);
			ps.addBatch();// 添加到批量处理中
			if (i % 200 == 0) {
				ps.executeBatch();// 执行批量操作
				ps.clearBatch();// 清楚批量处理中的操做缓存
				ps.clearParameters();// 清除批处理中的参数缓存
			}
		}
	}
}
