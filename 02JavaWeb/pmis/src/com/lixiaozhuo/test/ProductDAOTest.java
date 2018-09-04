package com.lixiaozhuo.test;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;

import com.lixiaozhuo.dao.IProductDAO;
import com.lixiaozhuo.dao.impl.ProductDAOImpl;
import com.lixiaozhuo.domain.Product;
import com.lixiaozhuo.page.PageResult;
import com.lixiaozhuo.query.ProductQueryObject;

//测试类
public class ProductDAOTest {
	IProductDAO objDAO = new ProductDAOImpl();

	// 测试插入信息
	@Test
	public void testSave() {
		Product obj = new Product(null, "xx", 2L, BigDecimal.TEN, "lxz", "lxz",
				new BigDecimal("0.9"), BigDecimal.TEN);
		objDAO.save(obj);
	}

	// 测试更新信息
	@Test
	public void testUpdate() {
		Product obj = new Product(24L, "xox", 2L, BigDecimal.TEN, "lxz", "lxz",
				new BigDecimal("0.8"), BigDecimal.ZERO);
		objDAO.update(obj);
	}

	// 测试删除信息
	@Test
	public void testDelete() {
		objDAO.delete(24L);
	}

	// 测试根据id查询信息
	@Test
	public void testGet() {
		Product obj = objDAO.get(20L);
		System.out.println(obj);
	}

	// 测试查询所有信息
	@Test
	public void testList() {
		List<Product> objs = objDAO.list();
		for (Product obj : objs) {
			System.out.println(obj);
		}
	}

	// 测试查询部分信息
	@Test
	public void testQueryCondition() {
		ProductQueryObject pqo = new ProductQueryObject();// 封装要查询的条件
		pqo.setName("m");
		pqo.setMinPrice(new BigDecimal("50"));
		pqo.setMaxPrice(new BigDecimal("100"));
		List<Product> objs = objDAO.queryCondition(pqo);// 按条件查询
		for (Product obj : objs) {
			System.out.println(obj);
		}
	}

	// 测试分页查询
	@Test
	public void testQueryPage() {
		Integer currentPage = 11;
		Integer pageSize = 2;
		PageResult result = objDAO.queryPage(currentPage, pageSize);// 分页查询
		System.out.print("第一页:" + result.getFirstPage() + "   ");
		System.out.print("上一页:" + result.getPrvePage() + "   ");
		System.out.print("下一页:" + result.getNextPage() + "   ");
		System.out.print("尾页:" + result.getEndPage() + "   ");
		System.out.println("数据总条数:" + result.getTotalCount());
		for (Object obj : result.getData()) {
			System.out.println(obj);
		}
	}

	// 测试查询部分信息
	@Test
	public void testQuery() {
		Integer currentPage = 1;
		Integer pageSize = 2;
		ProductQueryObject pqo = new ProductQueryObject();// 封装要查询的条件
		pqo.setName("m");
		pqo.setMinPrice(new BigDecimal("50"));
		pqo.setMaxPrice(new BigDecimal("100"));
		pqo.setCurrentPage(currentPage);
		pqo.setPageSize(pageSize);
		PageResult result = objDAO.query(pqo);// 分页查询
		System.out.print("第一页:" + result.getFirstPage() + "   ");
		System.out.print("上一页:" + result.getPrvePage() + "   ");
		System.out.print("下一页:" + result.getNextPage() + "   ");
		System.out.print("尾页:" + result.getEndPage() + "   ");
		System.out.println("数据总条数:" + result.getTotalCount());
		for (Object obj : result.getData()) {
			System.out.println(obj);
		}
	}
}
