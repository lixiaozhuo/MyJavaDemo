package com.lixiaozhuo.mapper;

import org.apache.ibatis.annotations.Param;

import com.lixiaozhuo.domain.Permission;

public interface PermissionMapper extends IGernericMapper<Permission>{
	Permission getByRole(@Param("roleId")Long roleId);
}
