package com.lixiaozhuo.query;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//商品查询类
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeQueryObject extends QueryObject {
	private String keyword;// 姓名或邮箱
	private Date beginDate;// 开始入职时间
	private Date endDate;// 结束入职时间

	/**
	 * 设置当前页面和每页显示记录值
	 * 
	 * @param currentPage
	 *            当前页面
	 * @param pageSize
	 *            每页显示记录数
	 */
	//
	public EmployeeQueryObject(Integer currentPage, Integer pageSize) {
		setCurrentPage(currentPage);
		setPageSize(pageSize);
	}

	// 自定义查询
	@Override
	protected void customizeQuery() {
		if (!isEmpty(keyword)) {
			addQuery(" username LIKE ? OR email LIKE ?", "%" + keyword + "%",
					"%" + keyword + "%");
		}
		if (beginDate != null) {
			addQuery(" hiredate >= ? ", beginDate);
		}
		if (endDate != null) {
			addQuery(" hiredate <= ? ", endDate);
		}
	}
	
	private boolean isEmpty(String str){
		return str == null || "".equals(str.trim());
	}
}
