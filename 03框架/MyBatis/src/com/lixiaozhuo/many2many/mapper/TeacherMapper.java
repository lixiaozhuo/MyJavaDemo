package com.lixiaozhuo.many2many.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lixiaozhuo.many2many.domain.Teacher;

public interface TeacherMapper {
	void add(Teacher obj);

	void update(Teacher obj);

	void delete(Long id);

	Teacher get(Long id);

	List<Teacher> list();

	void insertRelation(@Param("sutId") Long stuId, @Param("teaId") Long teaId);

	void deleteRelation(@Param("stuId") Long stuId, @Param("teaId") Long teaId);
}
