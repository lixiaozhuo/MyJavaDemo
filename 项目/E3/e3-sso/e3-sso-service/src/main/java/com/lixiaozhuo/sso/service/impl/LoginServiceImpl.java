package com.lixiaozhuo.sso.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.lixiaozhuo.jedis.JedisClient;
import com.lixiaozhuo.mapper.TbUserMapper;
import com.lixiaozhuo.pojo.E3Result;
import com.lixiaozhuo.pojo.TbUser;
import com.lixiaozhuo.pojo.TbUserExample;
import com.lixiaozhuo.pojo.TbUserExample.Criteria;
import com.lixiaozhuo.sso.service.LoginService;
import com.lixiaozhuo.utils.JsonUtils;

/**
 * 用户登录业务
 * 
 * @author lxz
 *
 */
@Service
public class LoginServiceImpl implements LoginService {
	/**
	 * 用户Mapper
	 */
	@Autowired
	private TbUserMapper userMapper;
	/**
	 * jedis客户端
	 */
	@Autowired
	private JedisClient jedisClient;
	
	/**
	 * session过期时间
	 */
	@Value("${SESSION_EXPIRE}")
	private Integer SESSION_EXPIRE;

	@Override
	public E3Result login(String username, String password) {
		// 根据用户名查询用户信息
		TbUserExample example = new TbUserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo(username);
		// 执行查询
		List<TbUser> list = userMapper.selectByExample(example);
		// 用户名不存在
		if (list == null || list.size() == 0) {
			return E3Result.build(500, "用户名或密码错误");
		}
		// 获取用户信息
		TbUser user = list.get(0);
		// 判断密码是否正确
		if (!DigestUtils.md5DigestAsHex(password.getBytes())
				.equals(user.getPassword())) {
			// 密码错误
			return E3Result.build(500, "用户名或密码错误");
		}

		// 生成token
		String token = UUID.randomUUID().toString();

		// 保护密码,清除用户信息中的密码
		user.setPassword("");
		// 用户信息写入redis,key:token value:用户信息
		jedisClient.set("SESSION:" + token, JsonUtils.objectToJson(user));
		// 设置session过期时间
		jedisClient.expire("SESSION:" + token, SESSION_EXPIRE);
		// 返回token
		return E3Result.ok(token);
	}
}
