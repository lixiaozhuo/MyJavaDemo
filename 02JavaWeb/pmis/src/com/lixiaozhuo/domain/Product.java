package com.lixiaozhuo.domain;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//实体类
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
	private Long id;//编号
	private String productName;//产品名称
	private Long dir_id;//类型编号
	private BigDecimal salePrice;//售价
	private String supplier;//厂商
	private String brand;//品牌
	private BigDecimal cutoff;//折扣
	private BigDecimal costPrice;//进价

	public String dirName() {//类型名字
		String name = null;
		if (dir_id == 2) {
			name = "无线鼠标";
		} else if (dir_id == 3) {
			name = "有线鼠标";
		}  else if (dir_id == 4) {
			name = "游戏鼠标";
		}
		return name;
	}
}
