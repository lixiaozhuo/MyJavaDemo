package com.lixiaozhuo.mapper;

import org.apache.ibatis.annotations.Param;

import com.lixiaozhuo.domain.Role;

public interface RoleMapper extends IGernericMapper<Role>{
	void insertRelation(@Param("roleId") Long roleId, @Param("perId") Long perId);

	void deleteRelation(@Param("roleId") Long roleId, @Param("perId") Long perId);
	
	Role getByEmployee(@Param("empId")Long empId);
}
