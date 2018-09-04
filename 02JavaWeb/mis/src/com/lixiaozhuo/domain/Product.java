package com.lixiaozhuo.domain;

import java.math.BigDecimal;
import java.util.List;

import com.lixiaozhuo.dao.IProductDirDAO;
import com.lixiaozhuo.dao.impl.ProductDirDAOImpl;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//商品类
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Product {
	private Long id;// 编号
	private String productName;// 产品名称
	private Long dir_id;// 类型编号
	private BigDecimal salePrice;// 售价
	private String supplier;// 厂商
	private String brand;// 品牌
	private BigDecimal cutoff;// 折扣
	private BigDecimal costPrice;// 进价
	
	/**
	 * 获取商品类型名字
	 * @return 商品类型名字
	 */
	public String dirName(){
		IProductDirDAO objDAO = new ProductDirDAOImpl();
		List<ProductDir> objs = objDAO.list();
		for (ProductDir obj : objs) {
			if(this.dir_id.equals(obj.getId() )){
				return obj.getDirName();
			}
		}
		return "";
	}
}
