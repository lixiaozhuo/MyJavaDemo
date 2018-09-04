package com.lixiaozhuo.domain;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Employee extends BaseDomain {
	@Override
	public String toString() {
		return "Employee [name=" + name + ", password=" + password + ", email="
				+ email + ", age=" + age + ", admin=" + admin + "]";
	}

	private String name;
	private String password;
	private String email;
	private Integer age;
	private Boolean admin;
	private Department dept;
	private List<Role> roles = new ArrayList<>();// 员工的所有角色

	public String getRoleName() {
		if (admin == true) {
			return "[系统管理员]";
		}
		if (roles.size() == 0) {
			return "暂无角色";
		}

		StringBuilder roleName = new StringBuilder(80);
		roleName.append("[");
		for (int i = 0; i < roles.size(); i++) {
			roleName.append(roles.get(i).getName());
			if (i < roles.size() - 1) {
				roleName.append(",");
			}
		}
		roleName.append("]");
		return roleName.toString();
	}
}
