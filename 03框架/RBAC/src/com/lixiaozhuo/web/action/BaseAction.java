package com.lixiaozhuo.web.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

//基本Action
public class BaseAction extends ActionSupport implements Preparable {
	private static final long serialVersionUID = 1L;
	public static final String LIST = "list";

	@Override
	public void prepare() throws Exception {
	}

	/**
	 * 向ActionContext中放数据
	 * 
	 * @param key
	 *            键
	 * @param value
	 *            值
	 */
	public void put(String key, Object value) {
		ActionContext.getContext().put(key, value);
	}

}
