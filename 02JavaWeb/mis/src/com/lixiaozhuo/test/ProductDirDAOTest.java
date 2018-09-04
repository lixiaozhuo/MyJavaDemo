package com.lixiaozhuo.test;

import java.util.List;

import org.junit.Test;

import com.lixiaozhuo.dao.IProductDirDAO;
import com.lixiaozhuo.dao.impl.ProductDirDAOImpl;
import com.lixiaozhuo.domain.ProductDir;

//测试类
public class ProductDirDAOTest {
	IProductDirDAO dao = new ProductDirDAOImpl();
	//列出所有商品类型信息
	@Test
	public void testList() {
		List<ProductDir> objs = dao.list();
		for (ProductDir obj : objs) {
			System.out.println(obj);
		}
	}

}
