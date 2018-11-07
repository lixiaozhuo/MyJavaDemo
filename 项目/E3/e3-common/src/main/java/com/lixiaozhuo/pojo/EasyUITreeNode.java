package com.lixiaozhuo.pojo;

import java.io.Serializable;

/**
 * 
 * EasyUI Tree控件响应结构
 * @author lxz
 *
 */
public class EasyUITreeNode implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/**
	 * 节点id
	 */
	private Long id;
	
	/**
	 * 节点文本
	 */
	private String text;
	
	/**
	 * 状态:如果节点下有子节点"closed"，如果没有子节点"open"
	 */
	private String state;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
}
