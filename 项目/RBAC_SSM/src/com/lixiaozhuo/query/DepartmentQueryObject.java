package com.lixiaozhuo.query;

import lombok.Getter;
import lombok.Setter;


public class DepartmentQueryObject extends QueryObject {
	

	@Override
	public String toString() {
		return "DepartmentQueryObject ["
				+ "getCurrentPage()=" + getCurrentPage() + ", getPageSize()="
				+ getPageSize() + ", keyword=" + keyword + "]";
	}

	@Setter
	@Getter
	private String keyword;// 关键字
}
