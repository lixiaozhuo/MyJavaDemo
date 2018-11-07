package com.lixiaozhuo.domain;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class Department  extends BaseDomain{
	@Override
	public String toString() {
		return "Department [getId()=" + getId() + ", name=" + name + ", sn="
				+ sn + "]";
	}
	private String name;
	private String sn;
}
