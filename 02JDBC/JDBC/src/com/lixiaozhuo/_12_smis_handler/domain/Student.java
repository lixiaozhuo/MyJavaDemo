package com.lixiaozhuo._12_smis_handler.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//实体类
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
	private Long id;
	private String name;
	private Integer age;
}
