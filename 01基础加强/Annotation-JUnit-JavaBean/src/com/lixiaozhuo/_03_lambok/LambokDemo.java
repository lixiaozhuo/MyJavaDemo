package com.lixiaozhuo._03_lambok;

import java.io.FileInputStream;
import java.io.InputStream;

import lombok.AllArgsConstructor;
import lombok.Cleanup;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data  
@Getter 
@Setter
@ToString
@NoArgsConstructor //空构造函数
@AllArgsConstructor//所有字段构造函数
public class LambokDemo {
	private String name;
	public static void main(String[] args) throws Exception {
		@Cleanup//自动关闭
		InputStream in = new FileInputStream("");
	}
}
