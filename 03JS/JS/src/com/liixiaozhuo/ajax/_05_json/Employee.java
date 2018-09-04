package com.liixiaozhuo.ajax._05_json;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Employee implements IJSONObject {
	private Long id;
	private String name;
	private String password;
	private Date hireDate;
	private Department dept;

	@SuppressWarnings("deprecation")
	@Override
	public Object toJson() {
		Map<String, Object> map = new HashMap<>();
		map.put("id", id);
		map.put("name", name);
		map.put("hireDate", hireDate.toLocaleString());
		map.put("dept", dept == null ? "" : dept.getName());
		return map;
	}

	// 创建一个Employee对象把其转换成json字符串,密码不需要转换,日期使用xxxx-xx-xx格式
	// dept如果存在,使用部门名称
	public static void main(String[] args) {
		Employee e = new Employee();
		e.setId(1L);
		e.setName("aaa");
		e.setPassword("5555");
		e.setHireDate(new Date());
		e.setDept(new Department(1L, "部门"));
		System.out.println(JSON.toJSONString(e.toJson()));
	}

}
