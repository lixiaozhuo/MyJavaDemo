package com.lixiaozhuo._06_transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.junit.Test;
import com.lixiaozhuo._05_smis_prepared_statement.jdbc_utils.JDBCUtil;

@SuppressWarnings("all")
// 事务处理//简称tx
public class TransactionTest {
	// 李转账1000给王
	@Test
	public void testAccount() {
		String sql = "SELECT balance FROM tb_account WHERE name = ? AND balance >= ? ";
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn.setAutoCommit(false);// 设置手动提交
			// 查询李余额是否大于1000
			ps = conn.prepareStatement(sql);
			ps.setString(1, "李");
			ps.setDouble(2, 1000);
			rs = ps.executeQuery();
			if (!rs.next()) {
				System.out.println("您的账户余额不足");
				return;
			}
			// 李账户减少1000
			sql = "UPDATE tb_account SET balance = balance - ? WHERE name = ?";
			ps = conn.prepareStatement(sql);
			ps.setDouble(1, 1000.00);
			ps.setString(2, "李");
			ps.executeUpdate();
			// 王账户增加1000
			sql = "UPDATE tb_account SET balance = balance + ? WHERE name = ?";
			ps = conn.prepareStatement(sql);
			ps.setDouble(1, 1000.00);
			ps.setString(2, "王");
			ps.executeUpdate();
			conn.commit();// 提交申请
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();// 回滚事务:释放数据库中的锁资源
			} catch (Exception e1) {
				e1.printStackTrace();
			}

		} finally {
			JDBCUtil.close(conn, ps, rs);
		}

	}
}
