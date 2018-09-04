package com.lixiaozhuo._10_cascade;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

//销售订单
@Getter@Setter
public class SaleOrderBill {
	private Long id;
	private String sn;//订单编号
	private String inputUser;//制单人
	private List<SaleOrderItem> items  = new ArrayList<>();
}
