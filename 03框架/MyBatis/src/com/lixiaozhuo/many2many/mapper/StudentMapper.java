package com.lixiaozhuo.many2many.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lixiaozhuo.many2many.domain.Student;

public interface StudentMapper {
	void add(Student obj);

	void update(Student obj);

	void delete(Long id);

	Student get(Long id);

	List<Student> list();
	
	Student getByTeacher(@Param("teaId")Long teaId);
}
