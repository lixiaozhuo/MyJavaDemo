package com.lixiaozhuo.sso.service;

import com.lixiaozhuo.pojo.E3Result;
import com.lixiaozhuo.pojo.TbUser;

/**
 * 注册服务接口
 * @author lxz
 *
 */
public interface RegisterService {
	/**
	 * 检查数据是否合法
	 * @param param  注册数据
	 * @param type 数据类型 1:用户名 2:手机号 3 :邮箱
	 * @return
	 */
	E3Result checkData(String param,int type);
	
	/**
	 * 注册
	 * @param user 用户数据
	 * @return
	 */
	E3Result register(TbUser user);
}
