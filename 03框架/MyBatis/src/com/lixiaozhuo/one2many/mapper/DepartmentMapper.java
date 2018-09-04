package com.lixiaozhuo.one2many.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lixiaozhuo.one2many.domain.Department;

public interface DepartmentMapper {
	void add(Department obj);

	void update(Department obj);

	void delete(Long id);

	Department get(Long id);

	List<Department> list();

	void updateRelation(@Param("deptId") Long deptId, @Param("empId") Long empId);
}
