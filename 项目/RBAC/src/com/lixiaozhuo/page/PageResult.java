package com.lixiaozhuo.page;

import java.util.List;

import lombok.Getter;

@Getter
public class PageResult<T> {
	private List<T> data;// 数据
	private Integer totalCount;// 总记录数

	private Integer pageSize;// 页面显示条数
	private Integer currentPage;// 当前页

	private Integer prevPage;// 上一页
	private Integer nextPage;// 下一页
	private Integer totalPage;// 总页数/尾页

	public PageResult(List<T> data, Integer totalCount, Integer pageSize,
			Integer currentPage) {
		super();
		this.data = data;
		this.totalCount = totalCount;
		this.pageSize = pageSize;
		this.currentPage = currentPage;
		this.totalPage = totalCount % pageSize == 0 ? totalCount / pageSize
				: totalCount / pageSize + 1;
		if(this.totalPage <= 0){//尾页不为0
			this.totalPage = 1;
		}
		//计算上一页和下一页
		this.prevPage = currentPage - 1 > 1 ? currentPage - 1 : 1;
		this.nextPage = currentPage + 1 < this.totalPage ? currentPage + 1
				: this.totalPage;
	}

}
