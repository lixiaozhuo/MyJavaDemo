package com.lixiaozhuo._13_query._04_result;

import java.math.BigDecimal;

import lombok.Getter;

//存储查询的数据
@Getter
public class EmployeeVO {
	public EmployeeVO(Long eid, String ename, BigDecimal esalary, Long did,
			String dname) {
		this.eid = eid;
		this.ename = ename;
		this.esalary = esalary;
		this.did = did;
		this.dname = dname;
	}
	@Override
	public String toString() {
		return "EmployeeVO [eid=" + eid + ", ename=" + ename + ", esalary="
				+ esalary + ", did=" + did + ", dname=" + dname + "]";
	}
	private Long eid;
	private String ename;
	private BigDecimal esalary;
	private Long did;
	private String dname;
}
