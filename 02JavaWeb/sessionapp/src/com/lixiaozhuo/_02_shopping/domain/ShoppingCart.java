package com.lixiaozhuo._02_shopping.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import lombok.Getter;


public class ShoppingCart {
	@Getter
	List<CartItem> list = new ArrayList<>();

	@Getter
	private BigDecimal totalPrice ;// 购物车总价

	// 更新总价
	private void setTotalPrice() {
		totalPrice = new BigDecimal("0");
		for (CartItem cartItem : list) {
			totalPrice = totalPrice.add(cartItem.getTotalPrice());
		}
	}

	public void remove(Long id) {
		Iterator<CartItem> iterator = list.iterator();
		while (iterator.hasNext()) {
			if (id.equals(iterator.next().getId())) {
				iterator.remove();
				break;
			}
		}
		// 更新总价
		setTotalPrice();
	}

	public void add(CartItem newCartItem) {
		boolean flag = false;//购物车是否已有此商品
		for (CartItem cartItem : list) {
			if (cartItem.getId().equals(newCartItem.getId())) {
				cartItem.setNum(cartItem.getNum() + newCartItem.getNum());
				flag = true;
				break;
			}
		}
		if(flag == false){
			list.add(newCartItem);
		}
		// 更新总价
		setTotalPrice();
	}
	
}
