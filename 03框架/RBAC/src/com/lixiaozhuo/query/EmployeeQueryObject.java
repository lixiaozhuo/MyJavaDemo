package com.lixiaozhuo.query;

import org.apache.commons.lang3.StringUtils;

import lombok.Getter;
import lombok.Setter;

public class EmployeeQueryObject extends QueryObject {
	@Setter
	@Getter
	private String keyword;//关键字

	@Setter
	@Getter
	private Long deptId;//部门编号

	//自定义高级查询
	@Override
	protected void customizeQuery() {
		if (StringUtils.isNotBlank(keyword)) {
			addCondition(" obj.name LIKE :keyword OR obj.email LIKE :keyword ",
					"keyword", "%" + keyword + "%");
		}
		if (deptId != null && deptId > 0) {
			addCondition(" obj.dept.id = :id ", "id", deptId);
		}
	}

}
