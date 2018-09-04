package com.lixiaozhuo.dao.impl;

import java.util.List;

import com.lixiaozhuo.dao.IProductDAO;
import com.lixiaozhuo.domain.Product;
import com.lixiaozhuo.handler.IResultSetHandler;
import com.lixiaozhuo.handler.impl.BeanHandler;
import com.lixiaozhuo.handler.impl.BeanListHandler;
import com.lixiaozhuo.handler.impl.ScaleHandler;
import com.lixiaozhuo.page.PageResult;
import com.lixiaozhuo.query.QueryObject;
import com.lixiaozhuo.template.jdbcTemplate;

//DAO接口实现类
public class ProductDAOImpl implements IProductDAO {

	private IResultSetHandler<Product> beanHandler = new BeanHandler<>(
			Product.class);
	private IResultSetHandler<List<Product>> beanListHandler = new BeanListHandler<>(
			Product.class);;
	private IResultSetHandler<Long> scaleHandler = new ScaleHandler();

	// 插入信息
	@Override
	public void save(Product obj) {
		String sql = "INSERT INTO product(id,productName,dir_id,salePrice,supplier,"
				+ "brand,cutoff,costPrice) VALUE(?,?,?,?,?,?,?,?); ";
		Object[] params = new Object[] { null, obj.getProductName(),
				obj.getDir_id(), obj.getSalePrice(), obj.getSupplier(),
				obj.getBrand(), obj.getCutoff(), obj.getCostPrice() };
		jdbcTemplate.update(sql, params);
	}

	// 修改信息
	@Override
	public void update(Product obj) {
		String sql = "UPDATE product SET productName = ?,dir_id = ?,salePrice = ?,"
				+ "supplier = ?,brand = ?,cutoff = ?,costPrice = ? WHERE id = ?";
		Object[] params = new Object[] { obj.getProductName(), obj.getDir_id(),
				obj.getSalePrice(), obj.getSupplier(), obj.getBrand(),
				obj.getCutoff(), obj.getCostPrice(), obj.getId() };
		jdbcTemplate.update(sql, params);
	}

	// 删除信息
	@Override
	public void delete(Long id) {
		String sql = "DELETE FROM product WHERE id = ?";
		jdbcTemplate.update(sql, id);
	}

	// 根据id查询信息
	@Override
	public Product get(Long id) {
		String sql = "SELECT * FROM product WHERE id = ?";
		return jdbcTemplate.query(sql, beanHandler, id);
	}

	// 查询所有信息
	@Override
	public List<Product> list() {
		String sql = "SELECT * FROM product";
		return jdbcTemplate.query(sql, beanListHandler);
	}

	// 查询部分信息
	@Override
	public List<Product> queryCondition(QueryObject objs) {
		StringBuilder sql = new StringBuilder(80);
		sql.append("SELECT * FROM product ")
				.append(objs.getWhereAndLimitCase(false));
		List<Object> list = objs.getParams();
		System.out.println(sql);
		System.out.println(list);
		return jdbcTemplate
				.query(sql.toString(), beanListHandler, list.toArray());
	}

	// 分页查询信息
	@Override
	public PageResult queryPage(Integer currentPage, Integer pageSize) {
		// 查询页面数据
		String dataSql = "SELECT * FROM product LIMIT ? , ? ";
		Object[] params = new Object[] { (currentPage - 1) * pageSize,
				pageSize };
		List<Product> data = jdbcTemplate
				.query(dataSql, beanListHandler, params);
		// 查询总记录数
		String countSql = "SELECT COUNT(*) FROM product";
		Integer totalCount = jdbcTemplate.query(countSql, scaleHandler)
				.intValue();
		return new PageResult(data, totalCount, currentPage, pageSize);
	}

	// 高级查询
	@Override
	public PageResult query(QueryObject objs) {
		// 查询页面数据
		StringBuilder dataSql = new StringBuilder(80);
		dataSql.append("SELECT * FROM product ")
				.append(objs.getWhereAndLimitCase(true));
		List<Object> params = objs.getParams();
		System.out.println(dataSql);
		System.out.println(params);
		List<Product> data = jdbcTemplate
				.query(dataSql.toString(), beanListHandler, params.toArray());

		// 查询总记录数
		StringBuilder countSql = new StringBuilder(80);
		countSql.append("SELECT COUNT(*) FROM product")
				.append(objs.getWhereAndLimitCase(false));
		params = objs.getParams();
		Integer totalCount = jdbcTemplate
				.query(countSql.toString(), scaleHandler,params.toArray()).intValue();
		System.out.println(countSql);
		System.out.println(params);
		return new PageResult(data, totalCount, objs.getCurrentPage(),
				objs.getPageSize());
	}
}
