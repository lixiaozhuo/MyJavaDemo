package com.lixiaozhuo._11_smis_template.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.lixiaozhuo._11_smis_template.dao.IStudentDAO;
import com.lixiaozhuo._11_smis_template.domain.Student;
import com.lixiaozhuo._11_smis_template.handler.IResultSetHandler;
import com.lixiaozhuo._11_smis_template.template.jdbcTemplate;

//DAO接口实现类
public class StudentDAOImpl implements IStudentDAO {
	// 插入学生信息
	@Override
	public void save(Student stu) {
		String sql = "INSERT INTO tb_student(name,age) VALUE(?,?); ";
		Object[] params = new Object[] { stu.getName(), stu.getAge() };
		jdbcTemplate.update(sql, params);
	}

	// 删除学生信息
	@Override
	public void update(Student stu) {
		String sql = "UPDATE tb_student SET name = ?,age = ? WHERE id = ?";
		Object[] params = new Object[] { stu.getName(), stu.getAge(),
				stu.getId() };
		jdbcTemplate.update(sql, params);
	}

	// 修改学生信息
	@Override
	public void delete(Long id) {
		String sql = "DELETE FROM tb_student WHERE id = ?";
		jdbcTemplate.update(sql, id);
	}

	// 根据id查询学生信息
	@Override
	public Student get(Long id) {
		String sql = "SELECT id,name,age FROM tb_student WHERE id = ?";
		List<Student> stus = jdbcTemplate
				.query(sql, new StudentResultSetHandler(), id);
		return stus.size() != 0 ? stus.get(0) : null;
	}

	// 查询所有学生信息
	@Override
	public List<Student> list() {
		String sql = "SELECT id,name,age FROM tb_student";
		return jdbcTemplate.query(sql, new StudentResultSetHandler());
	}

	/**
	 * 结果集处理器
	 * 
	 * @author lxz
	 *
	 */
	class StudentResultSetHandler implements IResultSetHandler<List<Student>> {
		@Override
		public List<Student> handler(ResultSet rs) {
			List<Student> stus = new ArrayList<>();
			try {
				while (rs.next()) {
					Student stu = new Student(rs.getLong("id"),
							rs.getString("name"), rs.getInt("age"));
					stus.add(stu);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return stus;
		}

	}
}
