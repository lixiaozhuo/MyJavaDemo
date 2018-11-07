package com.lixiaozhuo.sso.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lixiaozhuo.pojo.E3Result;
import com.lixiaozhuo.sso.service.TokenService;

/**
 * token控制器
 * 
 * @author lxz
 *
 */
@Controller
public class TokenController {
	/**
	 * token服务
	 */
	@Autowired
	private TokenService tokenService;

	/*
	 * @RequestMapping(value = "/user/token/{token}", produces =
	 * MediaType.APPLICATION_JSON_UTF8_VALUE)
	 * 
	 * @ResponseBody public String getUserByToken(@PathVariable String token,
	 * String callback) { // 根据token查询用户信息 E3Result result =
	 * tokenService.getUserByToken(token);
	 * 
	 * // 判断是否跨域访问 if (StringUtils.isNotBlank(callback)) { // 把结果封装成一个js语句响应
	 * return callback + "(" + JsonUtils.objectToJson(result) + ");"; }
	 * 
	 * return JsonUtils.objectToJson(result); }
	 */

	@RequestMapping(value = "/user/token/{token}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Object getUserByToken(@PathVariable String token, String callback) {
		// 根据token查询用户信息
		E3Result result = tokenService.getUserByToken(token);

		// 判断是否跨域访问
		if (StringUtils.isNotBlank(callback)) {
			// 把结果封装成一个js语句响应
			MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(
					result);
			mappingJacksonValue.setJsonpFunction(callback);
			return mappingJacksonValue;
		}

		return result;
	}
}
