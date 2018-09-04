package com.lixiaozhuo._04_smis_util.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.lixiaozhuo._04_smis_util.dao.IStudentDAO;
import com.lixiaozhuo._04_smis_util.domain.Student;
import com.lixiaozhuo._04_smis_util.jdbc_utils.JDBCUtil;

//DAO接口实现类
public class StudentDAOImpl implements IStudentDAO {
	// 插入学生信息
	@Override
	public void save(Student stu) {
		// 工具类默认加载注册驱动
		// 获取连接对象
		try (Connection conn = JDBCUtil.getConnection();
				// 创建语句对象
				Statement statement = conn.createStatement();) {
			// 执行SQL语句
			StringBuilder str = new StringBuilder(
					"INSERT INTO mytable(name,age) VALUES (");
			str.append("'").append(stu.getName()).append("'");
			str.append(",");
			str.append("'").append(stu.getAge()).append("'");
			str.append(");");
			System.out.println(str);
			statement.executeUpdate(str.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 自动释放资源
	}

	// 删除学生信息
	@Override
	public void delete(Long id) {
		// 工具类默认加载注册驱动
		// 获取连接对象
		try (Connection conn = JDBCUtil.getConnection();
				// 创建语句对象
				Statement statement = conn.createStatement();) {
			// 执行SQL语句
			statement.executeUpdate("DELETE FROM mytable WHERE id = " + id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 自动释放资源
	}

	// 修改学生信息
	@Override
	public void update(Student stu) {
		// 工具类默认加载注册驱动
		// 获取连接对象
		try (Connection conn = JDBCUtil.getConnection();
				// 创建语句对象
				Statement statement = conn.createStatement();) {
			// 执行SQL语句
			StringBuilder str = new StringBuilder("UPDATE mytable SET ");
			str.append("name = '").append(stu.getName()).append("'");
			str.append(",");
			str.append("age = '").append(stu.getAge()).append("'");
			str.append(" WHERE id = ").append(stu.getId());
			str.append(";");
			System.out.println(str);
			statement.executeUpdate(str.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 自动释放资源
	}

	// 根据id查询学生信息
	@Override
	public Student get(Long id) {
		ResultSet rs = null;
		// 工具类默认加载注册驱动
		// 获取连接对象
		try (Connection conn = JDBCUtil.getConnection();
				// 创建语句对象
				Statement statement = conn.createStatement();) {
			// 执行SQL语句
			rs = statement.executeQuery(
					"SELECT id,name,age FROM mytable WHERE id = " + id);
			if (rs.next()) {// 读取数据
				Student stu = new Student(rs.getLong("id"),
						rs.getString("name"), rs.getInt("age"));
				return stu;
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
		// 自动释放资源
		return null;
	}

	// 查询所有学生信息
	@Override
	public List<Student> list() {
		// 工具类默认加载注册驱动
		// 获取连接对象
		List<Student> list = new ArrayList<>();
		ResultSet rs = null;
		try (Connection conn = JDBCUtil.getConnection();
				// 创建语句对象
				Statement statement = conn.createStatement();) {
			// 执行SQL语句
			rs = statement.executeQuery("SELECT id,name,age FROM mytable");
			// 读取数据
			while (rs.next()) {
				Student stu = new Student(rs.getLong("id"),
						rs.getString("name"), rs.getInt("age"));
				list.add(stu);
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
		// 自动释放资源
		return list;
	}

}
