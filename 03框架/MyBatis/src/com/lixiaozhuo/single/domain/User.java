package com.lixiaozhuo.single.domain;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter
@NoArgsConstructor
@AllArgsConstructor
@Alias("User")//注解配置别名
public class User implements Serializable{

	private static final long serialVersionUID = 1L;
	private Long id;
	private String username;
	private String password;
	private Integer age;
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password="
				+ password + ", age=" + age + "]";
	}
	
}
