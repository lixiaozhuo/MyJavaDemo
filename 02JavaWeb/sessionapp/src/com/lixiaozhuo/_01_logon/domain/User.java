package com.lixiaozhuo._01_logon.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//实体类
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
	private Long id;
	private String username;
	private String password;
}
