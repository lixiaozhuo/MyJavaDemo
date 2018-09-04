package com.lixiaozhuo._02_session.session;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//封装数据,存储要存放到session的数据 如需要共享数据则实现Serializable接口,使其可序列化
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name;
	private String password;
}
