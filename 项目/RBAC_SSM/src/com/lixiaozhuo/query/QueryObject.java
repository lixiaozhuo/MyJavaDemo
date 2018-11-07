package com.lixiaozhuo.query;

import lombok.Getter;
import lombok.Setter;

public abstract class QueryObject {
	@Getter@Setter
	private Integer currentPage = 1;//当前页
	@Getter@Setter
	private Integer pageSize = 10;//页面 记录数
		
	//默认首页为1,每页10条数据
	public QueryObject(){
		currentPage = 1;
		pageSize = 10;
	}
	
	//设置首页和页面显示条数
	public QueryObject(Integer currentPage,Integer pageSize){
		this.currentPage = currentPage;
		this.pageSize = pageSize;
	}
	
	public Integer getStartPage(){
		if(currentPage == null){
			currentPage = 1;
		}
		return (currentPage-1)*pageSize;
	}
}
