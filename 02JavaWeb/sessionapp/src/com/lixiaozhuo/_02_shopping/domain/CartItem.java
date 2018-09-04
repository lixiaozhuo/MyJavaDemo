package com.lixiaozhuo._02_shopping.domain;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//购物条目类
@ToString
@Getter
@Setter
public class CartItem {
	private Long id;// 商品id
	private String name;// 名称
	private BigDecimal price;// 单价
	private Integer num;// 数量
	private BigDecimal totalPrice;// 小记

	public CartItem(Long id, String name, BigDecimal price, Integer num) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.num = num;
		// 计算当前总价
		totalPrice = price.multiply(new BigDecimal(num));
	}

	public void setNum(Integer num) {
		this.num = num;
		// 更新总价
		totalPrice = price.multiply(new BigDecimal(num));
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
		// 更新总价
		totalPrice = price.multiply(new BigDecimal(num));
	}
}
