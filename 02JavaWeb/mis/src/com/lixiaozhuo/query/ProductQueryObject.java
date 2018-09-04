package com.lixiaozhuo.query;

import java.math.BigDecimal;

import com.mysql.cj.util.StringUtils;

import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.NoArgsConstructor;

//商品查询类
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductQueryObject extends QueryObject {
	private String name;// 模糊查询商品名称
	private BigDecimal minPrice;// 最低价格
	private BigDecimal maxPrice;// 最高价格
	private Long dir_id = 0L;// 商品种类
	private String keyword;// 关键字
	
	/**
	 *  设置当前页面和每页显示记录值
	 * @param currentPage 当前页面
	 * @param pageSize 每页显示记录数
	 */
	//
	public ProductQueryObject(Integer currentPage, Integer pageSize) {
		setCurrentPage(currentPage);
		setPageSize(pageSize);
	}
	
	//自定义查询
	@Override
	protected void customizeQuery() {
		if (!StringUtils.isEmptyOrWhitespaceOnly(name)) {
			addQuery(" productName LIKE ?", "%" + name + "%");
		}
		if (minPrice != null) {
			addQuery(" salePrice >= ? ", minPrice);
		}
		if (maxPrice != null) {
			addQuery(" salePrice<=? ", maxPrice);
		}
		if (dir_id > 0) {
			addQuery(" dir_id = ?", dir_id);
		}
		if (!StringUtils.isEmptyOrWhitespaceOnly(keyword)) {
			addQuery(" productName LIKE ? OR supplier LIKE ? OR brand LIKE ?",
					"%" + name + "%", "%" + name + "%", "%" + name + "%");
		}
	}

}
