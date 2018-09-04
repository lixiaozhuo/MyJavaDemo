package com.lixiaozhuo.many2many.service;

import java.util.List;

import com.lixiaozhuo.many2many.domain.Student;

public interface IStudentService {
	void save(Student obj);
	
	void update(Student obj);
	
	void delete(Long id);
	
	Student get(Long id);
	
	List<Student> list();
}
