package com.lixiaozhuo._07_parm;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
	@Setter
	private String username;
	@Setter
	private String age;
}
