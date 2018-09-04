package com.lixiaozhuo.dao;

import java.util.List;

import com.lixiaozhuo.domain.Student;

//学生DAO接口
public interface IStudentDAO {
	/**
	 * 保存学生信息
	 * 
	 * @param stu
	 *            要保存的学生信息
	 */
	void save(Student stu);

	/**
	 * 更新学生信息
	 * 
	 * @param stu
	 *            要更新的学生信息
	 */
	void update(Student stu);

	/**
	 * 删除指定id学生信息
	 * 
	 * @param id
	 *            要删除学生的id
	 */
	void delete(Long id);

	/**
	 * 得到指定id学生信息
	 * 
	 * @param id
	 *            要查询的学生id
	 * @return 查询的学生信息
	 */
	Student get(Long id);

	/**
	 * 得到所有学生信息
	 * 
	 * @return 所有学生信息集
	 */
	List<Student> list();
}
