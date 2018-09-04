package com.lixiaozhuo.smis.dao.impl;

import java.util.List;

import com.lixiaozhuo.smis.dao.IStudentDAO;
import com.lixiaozhuo.smis.domain.Student;
import com.lixiaozhuo.smis.handler.BeanHandler;
import com.lixiaozhuo.smis.handler.BeanListHandler;
import com.lixiaozhuo.smis.template.jdbcTemplate;

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
		return jdbcTemplate.query(sql, new BeanHandler<>(Student.class), id);
	}

	// 查询所有学生信息
	@Override
	public List<Student> list() {
		String sql = "SELECT id,name,age FROM tb_student";
		return jdbcTemplate.query(sql, new BeanListHandler<>(Student.class));
	}
}
