package com.lixiaozhuo.query;

import java.math.BigDecimal;

import com.mysql.jdbc.StringUtils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductQueryObject extends QueryObject {
	private String name;// 模糊查询商品名称
	private BigDecimal minPrice;// 最低价格
	private BigDecimal maxPrice;// 最高价格
	private Long dir_id = 0L;// 商品种类
	private String keyword;// 关键字
	// 将自定义查询条件和参数存放到父类容器中
	
	public ProductQueryObject(Integer currentPage,Integer pageSize){
		setCurrentPage(currentPage);
		setPageSize(pageSize);
	}
	
	@Override
	protected void customizeQuery() {
		if (!StringUtils.isEmptyOrWhitespaceOnly(name)) {
			addQuery("  productName LIKE ? ", "%" + name + "%");
		}
		if (minPrice != null) {
			addQuery(" salePrice >= ? ", minPrice);
		}
		if (maxPrice != null) {
			addQuery(" salePrice <= ? ", maxPrice);
		}
		if (dir_id > 0) {
			addQuery(" dir_id = ? ", dir_id);
		}
		if (!StringUtils.isEmptyOrWhitespaceOnly(keyword)) {
			addQuery("  productName LIKE ? OR supplier LIKE ? OR brand LIKE ? ",
					"%" + keyword + "%" ,"%" + keyword + "%" ,"%" + keyword + "%" );
		}
	}
}
