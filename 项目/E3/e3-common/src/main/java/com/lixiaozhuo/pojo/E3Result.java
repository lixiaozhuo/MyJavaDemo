package com.lixiaozhuo.pojo;

import java.io.Serializable;

/**
 * 商城页面响应结构
 */
public class E3Result implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 响应状态:200为成功
	 * 其他为失败
	 */
	private Integer status;

	/**
	 * 响应消息
	 */
	private String msg;

	/**
	 * 响应数据
	 */
	private Object data;

	/**
	 * 构造函数
	 * 
	 * @param status
	 *            响应状态:200为成功
	 * @param msg
	 *            响应消息
	 * @param data
	 *            响应中的数据
	 */
	private E3Result(Integer status, String msg, Object data) {
		this.status = status;
		this.msg = msg;
		this.data = data;
	}
	

	/**
	 * 创建返回对象
	 * 
	 * @param status
	 *            响应业务状态 200为成功,其他为失败
	 * @param msg
	 *            响应消息
	 * @param data
	 *            响应中的数据
	 * @return 返回对象
	 */
	public static E3Result build(Integer status, String msg, Object data) {
		return new E3Result(status, msg, data);
	}

	public static E3Result build(Integer status, String msg) {
		return new E3Result(status, msg, null);
	}

	/**
	 * 返回成功信息
	 * 
	 * @param data
	 *            响应中的数据
	 * @return 包含成功状态的返回对象
	 */
	public static E3Result ok(Object data) {
		return build(200,"ok",data);
	}

	public static E3Result ok() {
		return build(200,"ok",null);
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}
