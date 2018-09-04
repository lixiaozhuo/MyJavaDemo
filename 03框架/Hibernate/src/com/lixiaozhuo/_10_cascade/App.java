package com.lixiaozhuo._10_cascade;

import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;

import com.lixiaozhuo.utils.HibernateUtil;

//级联测试
public class App {
	@Before
	public void before() {
		SaleOrderBill bill = new SaleOrderBill();
		bill.setSn("123456");
		bill.setInputUser("will");

		SaleOrderItem item1 = new SaleOrderItem();
		item1.setNumber(2);
		item1.setProductName("泡椒凤爪");
		SaleOrderItem item2 = new SaleOrderItem();
		item2.setNumber(6);
		item2.setProductName("啤酒");

		bill.getItems().add(item1);
		bill.getItems().add(item2);

		item1.setBill(bill);
		item2.setBill(bill);
		Session session = HibernateUtil.getSession();
		session.beginTransaction();

		session.save(bill);//级联添加
		// session.save(item1);
		// session.save(item2);

		session.getTransaction().commit();
		session.close();
	}

	@Test
	public void testDelete() {
		SaleOrderBill bill = new SaleOrderBill();

		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		// 删除主对象前主对象中存在从对象
		bill = session.get(SaleOrderBill.class, 1L);
		session.delete(bill);// 级联删除

		session.getTransaction().commit();
	}
}
