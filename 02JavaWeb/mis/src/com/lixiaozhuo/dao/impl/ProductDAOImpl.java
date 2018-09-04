package com.lixiaozhuo.dao.impl;

import java.util.List;

import com.lixiaozhuo.dao.IProductDAO;
import com.lixiaozhuo.domain.Product;
import com.lixiaozhuo.handle.IResultSetHandler;
import com.lixiaozhuo.handle.impl.BeanHandler;
import com.lixiaozhuo.handle.impl.BeanListHandler;
import com.lixiaozhuo.handle.impl.ScaleHandler;
import com.lixiaozhuo.page.PageResult;
import com.lixiaozhuo.query.QueryObject;
import com.lixiaozhuo.utils.JDBCTemplate;

//商品DAO接口实现类
public class ProductDAOImpl implements IProductDAO {
	private IResultSetHandler<Product> beanHandler = new BeanHandler<>(
			Product.class);
	private IResultSetHandler<List<Product>> beanListHandler = new BeanListHandler<>(
			Product.class);
	private IResultSetHandler<Long> scaleHandler = new ScaleHandler<>();

	// 插入信息
	@Override
	public void save(Product obj) {
		String sql = "INSERT INTO product(id,productName,dir_id,salePrice,supplier,brand,cutoff,costPrice) "
				+ "VALUES (?,?,?,?,?,?,?,?) ";
		Object[] params = new Object[] { null, obj.getProductName(),
				obj.getDir_id(), obj.getSalePrice(), obj.getSupplier(),
				obj.getBrand(), obj.getCutoff(), obj.getCostPrice() };
		JDBCTemplate.update(sql, params);
	}

	// 修改信息
	@Override
	public void update(Product obj) {
		String sql = "UPDATE product SET productName=?,dir_id=?,salePrice=?,"
				+ "supplier=?,brand=?,cutoff=?,costPrice=? WHERE id=?";
		Object[] params = new Object[] { obj.getProductName(), obj.getDir_id(),
				obj.getSalePrice(), obj.getSupplier(), obj.getBrand(),
				obj.getCutoff(), obj.getCostPrice(), obj.getId() };
		JDBCTemplate.update(sql, params);
	}

	// 删除信息
	@Override
	public void delete(Long id) {
		String sql = "DELETE FROM product WHERE id=?";
		JDBCTemplate.update(sql, id);
	}

	// 根据id查询信息
	@Override
	public Product get(Long id) {
		String sql = "SELECT * FROM product WHERE id=?";
		Product product = JDBCTemplate.query(beanHandler, sql, id);
		return product;
	}

	// 高级查询
	@Override
	public PageResult query(QueryObject obj) {
		// 查询页面数据
		StringBuilder dataSql = new StringBuilder(80);
		dataSql.append("SELECT * FROM product ")
				.append(obj.getWhereAndLimitCase(true));
		List<Object> params = obj.getParams();
		System.out.println(dataSql);
		System.out.println(params);
		List<Product> data = JDBCTemplate.query(beanListHandler,
				dataSql.toString(), params.toArray());
		// 查询总记录数
		StringBuilder countSql = new StringBuilder(80);
		countSql.append("SELECT COUNT(*) FROM product")
				.append(obj.getWhereAndLimitCase(false));
		params = obj.getParams();
		Integer totalCount = JDBCTemplate
				.query(scaleHandler, countSql.toString(), params.toArray())
				.intValue();
		return new PageResult(data, totalCount, obj.getCurrentPage(),
				obj.getPageSize());
	}

}
