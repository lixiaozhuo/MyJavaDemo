package com.lixiaozhuo.query;

import lombok.Getter;
import lombok.Setter;

public class EmployeeQueryObject extends QueryObject {
	@Setter
	@Getter
	private String keyword;//关键字

	@Setter
	@Getter
	private Long deptId;//部门编号
}
