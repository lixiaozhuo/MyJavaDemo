package com.lixiaozhuo.many2many.service;

import java.util.List;

import com.lixiaozhuo.many2many.domain.Teacher;

public interface ITeacherService {
	void save(Teacher obj);
	
	void update(Teacher obj);
	
	void delete(Long id);
	
	Teacher get(Long id);
	
	List<Teacher> list();
}
