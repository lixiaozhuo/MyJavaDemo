package com.lixiaozhuo._09_smis_dbcp.dao;

import java.util.List;
import com.lixiaozhuo._09_smis_dbcp.domain.Student;

//StudentDAO接口
public interface IStudentDAO {
	/**
	 * 插入学生信息
	 * 
	 * @param stu
	 *            要插入的学生信息
	 */
	void save(Student stu);

	/**
	 * 删除学生信息
	 * 
	 * @param id
	 *            要删除的学生id
	 */
	void delete(Long id);

	/**
	 * 修改学生信息
	 * 
	 * @param stu
	 *            要修改的学生信息对象
	 */
	void update(Student newStu);

	/**
	 * 根据id查询学生信息
	 * 
	 * @param id
	 *            要查询的学生id
	 * @return 指定 id的学生信息,如果不存在则返回为null
	 */
	Student get(Long id);

	/**
	 * 查询所有学生信息
	 * 
	 * @return 所有学生信息集合,如果为空则返回空集合
	 */
	List<Student> list();
}
