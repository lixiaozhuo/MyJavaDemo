package com.lixiaozhuo._09_smis_dbcp.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//实体类
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Student {
	private Long id;
	private String name;
	private Integer age;
}
