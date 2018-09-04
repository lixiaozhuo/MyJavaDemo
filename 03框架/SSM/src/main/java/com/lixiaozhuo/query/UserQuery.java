package com.lixiaozhuo.query;

import lombok.Getter;
import lombok.Setter;

@Setter@Getter
public class UserQuery {
	private String keyword;
	private Integer beginAge;
	private Integer endAge;
	
	private Integer pageSize;// 页面显示条数
	private Integer currentPage;// 当前页
	
	public UserQuery(){
		this.pageSize=3;
		this.currentPage=1;
	}
	
	public Integer getStartPage(){
		return (currentPage-1)*pageSize;
	}
}
