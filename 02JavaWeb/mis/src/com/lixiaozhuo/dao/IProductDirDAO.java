package com.lixiaozhuo.dao;

import java.util.List;

import com.lixiaozhuo.domain.ProductDir;

//商品类型DAO接口
public interface IProductDirDAO {
		
	/**
	 * 获取所有类型信息
	 * @return 所有类型信息
	 */
	List<ProductDir> list();
}
