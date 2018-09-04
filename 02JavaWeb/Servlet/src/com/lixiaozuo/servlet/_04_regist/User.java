package com.lixiaozuo.servlet._04_regist;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
	private String username;
	private String password;
	private String gender;
	private String city;
	private String info;
}
