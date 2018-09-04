package com.lixiaozhuo.query;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

public abstract class QueryObject {
	@Getter@Setter
	private Integer currentPage; // 当前页
	@Getter@Setter
	private Integer pageSize; // 每页显示记录数
	private List<Object> params = new ArrayList<>();// 封装占位符参数
	private List<String> conditions = new ArrayList<>();// 封装SQL片段

	/**
	 * 暴露给子类实现子类的自定义查询条件
	 */
	protected abstract void customizeQuery();

	/**
	 * 子类的查询条件和参数添加到父类的容器中
	 * 
	 * @param condition
	 *            查询条件
	 * @param param
	 *            参数
	 */
	protected void addQuery(String condition, Object... param) {
		conditions.add("(" + condition + ")");// 添加条件
		params.addAll(Arrays.asList(param));// 添加参数
	}

	/**
	 * 获得拼接好的where语句片段和分页片段
	 * 
	 * @param flag
	 *            是否添加分页片段
	 * @return 拼接好的where语句及分页语句
	 */
	public String getWhereAndLimitCase(Boolean flag) {
		StringBuilder sql = new StringBuilder(80);
		params.clear();
		conditions.clear();
		customizeQuery();// 自定义查询
		// 拼接条件
		if (conditions.size() > 0) {
			sql.append(" WHERE ");
			for (String str : conditions) {
				sql.append(str).append(" AND ");
			}
			// 去除多余的字符
			sql.delete(sql.lastIndexOf("AND"), sql.length());
		}

		// 添加分页信息
		if (flag == true) {
			sql.append(" LIMIT ?,? ");
			params.add((currentPage - 1) * pageSize);
			params.add(pageSize);
		}
		return sql.toString();
	}

	/**
	 * 获得参数列表
	 * 
	 * @return 参数列表
	 */
	public List<Object> getParams() {
		return params;
	}
}
