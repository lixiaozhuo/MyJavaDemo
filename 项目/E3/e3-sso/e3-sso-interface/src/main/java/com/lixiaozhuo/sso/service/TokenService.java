package com.lixiaozhuo.sso.service;

import com.lixiaozhuo.pojo.E3Result;

/**
 * token服务
 * @author lxz
 *
 */
public interface TokenService {
	/**
	 * 根据token查询信息
	 * @param token 
	 * @return
	 */
	E3Result getUserByToken(String token);
}
