package com.lixiaozhuo.domain;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

//角色对象
@Setter
@Getter
public class Role extends BaseDomain {
	@Override
	public String toString() {
		return "Role [name=" + name + ", sn=" + sn + "]";
	}

	private Long id;
	private String name;
	private String sn;// 角色编码
	List<Permission> permissions  = new ArrayList<>();// 角色所有权限
}
