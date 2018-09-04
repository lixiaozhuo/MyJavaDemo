package com.lixiaozhuo.dao.impl;

import java.util.List;

import com.lixiaozhuo.dao.IProductDirDAO;
import com.lixiaozhuo.domain.ProductDir;
import com.lixiaozhuo.handle.IResultSetHandler;
import com.lixiaozhuo.handle.impl.BeanListHandler;
import com.lixiaozhuo.utils.JDBCTemplate;

//商品类型DAO接口实现类
public class ProductDirDAOImpl implements IProductDirDAO {
	private IResultSetHandler<List<ProductDir>> beanListHandler = new BeanListHandler<>(
			ProductDir.class);
	@Override
	
	//获取类型信息
	public List<ProductDir> list() {
		String sql = "SELECT * FROM productdir WHERE parent_id=?";
		return JDBCTemplate.query(beanListHandler,sql,1L);
	}

}
