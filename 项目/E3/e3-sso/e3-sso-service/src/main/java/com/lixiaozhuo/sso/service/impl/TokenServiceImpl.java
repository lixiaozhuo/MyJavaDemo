package com.lixiaozhuo.sso.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.lixiaozhuo.jedis.JedisClient;
import com.lixiaozhuo.pojo.E3Result;
import com.lixiaozhuo.pojo.TbUser;
import com.lixiaozhuo.sso.service.TokenService;
import com.lixiaozhuo.utils.JsonUtils;

/**
 * token服务
 * 
 * @author lxz
 *
 */
@Service
public class TokenServiceImpl implements TokenService {
	/**
	 * jedis自定义客户端
	 */
	@Autowired
	private JedisClient jedisClient;

	/**
	 * session过期时间
	 */
	@Value("${SESSION_EXPIRE}")
	private Integer SESSION_EXPIRE;

	@Override
	public E3Result getUserByToken(String token) {
		// 根据token到redis中取用户信息
		String json = jedisClient.get("SESSION:" + token);
		// 取不到用户信息,登录已经过期,返回登录过期
		if (StringUtils.isBlank(json)) {
			return E3Result.build(500, "登录过期");
		}
		// 取到用户信息,更新token的过期时间
		jedisClient.expire("SESSION:" + token, SESSION_EXPIRE);
		TbUser user = JsonUtils.jsonToPojo(json, TbUser.class);
		// 返回结果
		return E3Result.ok(user);
	}

}
