package com.lixiaozhuo.query;

import org.apache.commons.lang3.StringUtils;

import lombok.Getter;
import lombok.Setter;

public class DepartmentQueryObject extends QueryObject {
	@Setter@Getter
	private String keyword;//关键字
	
	//自定义高级查询
	@Override
	protected void customizeQuery() {
		if (StringUtils.isNotBlank(keyword)) {
			addCondition(" obj.name LIKE :keyword OR obj.sn LIKE :keyword ",
					"keyword", "%" + keyword + "%");
		}
	}

}
