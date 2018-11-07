package com.lixiaozhuo.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * EasyUI DataGrid控件响应结构
 * @author lxz
 */
@SuppressWarnings("rawtypes")
public class EasyUIDataGridResult implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/**
	 * 当前页
	 */
	private Long total;
	
	/**
	 * 数据
	 */
	private List rows;
	
	public Long getTotal() {
		return total;
	}
	public void setTotal(Long total) {
		this.total = total;
	}
	public List getRows() {
		return rows;
	}
	public void setRows(List rows) {
		this.rows = rows;
	}
	
	
}
