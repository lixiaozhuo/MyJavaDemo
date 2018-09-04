package com.lixiaozhuo._13_query.domain;

import lombok.Getter;
import lombok.Setter;

//部门对象
@Getter@Setter
public class Department {
	@Override
	public String toString() {
		return "Department [id=" + id + ", sn=" + sn + ", name=" + name
				+ ", provice=" + provice + ", city=" + city + ", street="
				+ street + "]";
	}

	private Long id;
	private String sn;
	private String name;
	private String provice;//省份
	private String city;//城市
	private String street;//街道
	
	//many2one 多个部门可以属于同一个经理
	private Employee manager;//经理
}
