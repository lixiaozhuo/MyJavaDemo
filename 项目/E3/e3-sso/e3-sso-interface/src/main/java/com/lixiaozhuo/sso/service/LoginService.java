package com.lixiaozhuo.sso.service;

import com.lixiaozhuo.pojo.E3Result;

/**
 * 用户登录服务接口
 * @author lxz
 *
 */
public interface LoginService {
	/**
	 * 用户登录
	 * @param username 用户名
	 * @param password 密码
	 * @return
	 */
	E3Result login(String username,String password);
	
}
