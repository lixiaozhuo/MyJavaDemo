package com.lixiaozhuo._15_static_proxy_upgrade;

import java.lang.reflect.Method;

public interface IHandler {
	/**
	 * 
	 * @param m 真实调用方法的引用
	 * @param args 真实调用方法需要传入的参数 
	 */
	void invoke(Method m,Object[] args);
}
