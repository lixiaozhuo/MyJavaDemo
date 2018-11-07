package com.lixiaozhuo.query;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import lombok.Getter;
import lombok.Setter;

public abstract class QueryObject {
	@Getter@Setter
	private Integer currentPage;//当前页
	@Getter@Setter
	private Integer pageSize;//页面 记录数
	
	//存储条件
	private List<String> conditions = new ArrayList<>();
	
	//存储占位符对应参数
	private Map<String,Object> params = new HashMap<>();
	
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
	/**
	 * 子类自定义查询,由子类实现
	 */
	protected abstract void customizeQuery();
	
	/**
	 * 添加条件和参数
	 * @param condition 条件
	 * @param key 占位符标志
	 * @param value 占位符对应参数
	 */
	protected void addCondition(String condition,String key,Object value){
		conditions.add("(" + condition + ")");
		params.put(key, value);
	}
	
	/**
	 * 拼接条件语句
	 * @return 条件语句
	 */
	public String getCondition(){
		conditions.clear();
		params.clear();
		customizeQuery();
		if(conditions.size() > 0 ){
			StringBuilder str = new StringBuilder();
			str.append(" WHERE ").append(StringUtils.join(conditions," AND "));
			return str.toString();
		}		
		return " ";
	}
	
	/**
	 * 获取参数
	 * @return 占位符对应参数
	 */
	public Map<String,Object> getParams(){
		return params;
	}
}
