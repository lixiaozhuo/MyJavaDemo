package com.lixiaozhuo._07_blob;

import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import org.junit.Test;
import com.lixiaozhuo._05_smis_prepared_statement.jdbc_utils.JDBCUtil;

//二进制操作
public class BlobTest {
	// 写入二进制操作
	@Test
	public void testWrite() throws Exception {
		Connection conn = JDBCUtil.getConnection();
		String sql = "INSERT INTO tb_image(image) VALUES (?)";
		PreparedStatement ps = conn
				.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);// 设置返回生成主键
		ps.setBlob(1, new FileInputStream("c:/SuppressWarnings.png"));
		ps.executeUpdate();
		ResultSet rs = ps.getGeneratedKeys();// 获取自动生成的主键
		if (rs.next()) {
			System.out.println(rs.getLong(1));
		}
		JDBCUtil.close(conn, ps, rs);
	}

	// 读取二进制
	@Test
	public void testRead() throws Exception {
		Connection conn = JDBCUtil.getConnection();
		String sql = "SELECT image FROM tb_image WHERE id = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setLong(1, 1L);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			Blob bl = rs.getBlob("image");
			InputStream in = bl.getBinaryStream();
			// java7复制粘贴
			Files.copy(in, Paths.get("c:/file/a.png"));
		}
		JDBCUtil.close(conn, ps, rs);
	}
}
