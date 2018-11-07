package com.lixiaozhuo.sso.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.lixiaozhuo.mapper.TbUserMapper;
import com.lixiaozhuo.pojo.E3Result;
import com.lixiaozhuo.pojo.TbUser;
import com.lixiaozhuo.pojo.TbUserExample;
import com.lixiaozhuo.pojo.TbUserExample.Criteria;
import com.lixiaozhuo.sso.service.RegisterService;

/**
 * 用户注册服务
 * 
 * @author lxz
 *
 */
@Service
public class RegisterServiceImpl implements RegisterService {
	/**
	 * 用户Mapper
	 */
	@Autowired
	private TbUserMapper userMapper;

	@Override
	public E3Result checkData(String param, int type) {
		// 根据不同的type生成不同的查询条件
		TbUserExample example = new TbUserExample();
		Criteria criteria = example.createCriteria();
		// 1:用户名 2:手机号 3:邮箱
		if (type == 1) {
			criteria.andUsernameEqualTo(param);
		} else if (type == 2) {
			criteria.andPhoneEqualTo(param);
		} else if (type == 3) {
			criteria.andEmailEqualTo(param);
		} else {
			return E3Result.build(500, "数据类型错误");
		}
		// 执行查询
		List<TbUser> list = userMapper.selectByExample(example);
		// 判断结果中是否包含数据
		if (list != null && list.size() > 0) {
			// 如果有数据返回false
			return E3Result.ok(false);
		}

		// 如果没有数据返回true
		return E3Result.ok(true);
	}

	@Override
	public E3Result register(TbUser user) {
		// 校验数据有效性
		if (StringUtils.isBlank(user.getUsername())
				|| StringUtils.isBlank(user.getPassword())
				|| StringUtils.isBlank(user.getPhone())) {
			return E3Result.build(500, "用户数据不完整");
		}
		if (!(boolean) checkData(user.getUsername(), 1).getData()) {
			return E3Result.build(500, "用户名已被注册");
		}
		if (!(boolean) checkData(user.getPhone(), 2).getData()) {
			return E3Result.build(500, "手机号已被注册");
		}

		// 补全user属性
		user.setCreated(new Date());
		user.setUpdated(new Date());
		// 加密用户密码
		String md5Password = DigestUtils
				.md5DigestAsHex(user.getPassword().getBytes());
		user.setPassword(md5Password);
		// 添加数据
		userMapper.insert(user);
		// 返回添加成功
		return E3Result.ok();
	}

}
