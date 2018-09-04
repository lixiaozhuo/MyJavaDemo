package com.lixiaozhuo._09_smis_dbcp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.lixiaozhuo._09_smis_dbcp.dao.IStudentDAO;
import com.lixiaozhuo._09_smis_dbcp.domain.Student;
import com.lixiaozhuo._09_smis_dbcp.jdbc_util.DBCPUtil;

//DAO接口实现类
public class StudentDAOImpl implements IStudentDAO {
	// 插入学生信息
	@Override
	public void save(Student stu) {
		String sql = "INSERT INTO mytable(name,age) VALUES (?,?)";
		// 工具类默认加载注册驱动
		// 获取连接对象
		try (Connection conn = DBCPUtil.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);) {
			// 设置数据
			ps.setString(1, stu.getName());
			ps.setInt(2, stu.getAge());
			// 执行SQL语句
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 删除学生信息
	@Override
	public void delete(Long id) {
		String sql = "DELETE FROM mytable WHERE id = ?";
		// 工具类默认加载注册驱动
		// 获取连接对象
		try (Connection conn = DBCPUtil.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);) {
			// 设置数据
			ps.setLong(1, id);
			// 执行SQL语句
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 修改学生信息
	@Override
	public void update(Student newStu) {
		String sql = "UPDATE mytable SET name = ?,age = ? WHERE id = ?";
		// 工具类默认加载注册驱动
		// 获取连接对象
		try (Connection conn = DBCPUtil.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);) {
			// 设置数据
			ps.setString(1, newStu.getName());
			ps.setInt(2, newStu.getAge());
			ps.setLong(3, newStu.getId());
			// 执行SQL语句
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 根据id查询学生信息
	@Override
	public Student get(Long id) {
		String sql = "SELECT id,name,age FROM mytable WHERE id = ?";
		ResultSet rs = null;
		// 工具类默认加载注册驱动
		// 获取连接对象
		try (Connection conn = DBCPUtil.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);) {
			// 设置数据
			ps.setLong(1, id);
			// 执行SQL语句
			rs = ps.executeQuery();
			if (rs.next()) {
				return new Student(rs.getLong("id"), rs.getString("name"),
						rs.getInt("age"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	// 查询所有学生信息
	@Override
	public List<Student> list() {
		String sql = "SELECT id,name,age FROM mytable";
		List<Student> stus = new ArrayList<>();
		ResultSet rs = null;
		// 工具类默认加载注册驱动
		// 获取连接对象
		try (Connection conn = DBCPUtil.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);) {
			// 执行SQL语句
			rs = ps.executeQuery();
			while (rs.next()) {
				Student stu = new Student(rs.getLong("id"),
						rs.getString("name"), rs.getInt("age"));
				stus.add(stu);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return stus;
	}

}
