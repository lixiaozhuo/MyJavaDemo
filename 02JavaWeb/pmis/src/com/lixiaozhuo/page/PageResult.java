package com.lixiaozhuo.page;

import java.util.List;

import lombok.Getter;

//页面结果集
@Getter
public class PageResult {
	private List<?> data;// 封装页面数据
	private Integer totalCount;// 总记录数

	private Integer currentPage;// 当前页
	private Integer pageSize;// 每页显示记录数

	private final Integer firstPage = 1;// 首页
	private Integer prvePage;// 上一页
	private Integer nextPage;// 下一页
	private Integer endPage;// 总页数/尾页

	// 初始化参数
	public PageResult(List<?> data, Integer totalCount, Integer currentPage,
			Integer pageSize) {
		this.data = data;
		this.totalCount = totalCount;
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		endPage = totalCount % pageSize == 0 ? totalCount / pageSize
				: totalCount / pageSize + 1;
		prvePage = currentPage - 1 >= 1 ? currentPage - 1 : 1;
		nextPage = currentPage + 1 <= endPage ? currentPage + 1 : endPage;
	}

}
