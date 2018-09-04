package com.lixiaozhuo._10_cascade;

import lombok.Getter;
import lombok.Setter;

//销售订单明细
@Getter@Setter
public class SaleOrderItem {
	private Long id;
	private String productName;//货品名称
	private Integer number;//数量
	private SaleOrderBill  bill;
}
