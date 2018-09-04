package com.lixiaozhuo.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//商品类型类
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductDir {
	private Long id;
	private String dirName;
	private Long parent_id;
}
