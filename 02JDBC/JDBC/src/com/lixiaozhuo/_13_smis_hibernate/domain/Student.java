package com.lixiaozhuo._13_smis_hibernate.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//实体类
@Data
@AllArgsConstructor
@NoArgsConstructor
@SqlTable("tb_student")
public class Student {
	@SqlField("id")
	private Long id;
	@SqlField("name")
	private String name;
	@SqlField("age")
	private Integer age;
}
