package com.lixiaozhuo.pojo;

import java.io.Serializable;

/**
 * 搜索内容封装
 * 
 * @author lxz
 *
 */
public class SearchItem implements Serializable{

	private static final long serialVersionUID = 1L;
	private String id;// id
	private String title;// 商品标题
	private String sell_point;// 商品卖点
	private long price;// 价格
	private String image;// 图片
	private String category_name;// 分类名

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSell_point() {
		return sell_point;
	}

	public void setSell_point(String sell_point) {
		this.sell_point = sell_point;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}
	
	/**
	 * 图片数组
	 * @return
	 */
	public String[] getImages() {
		if(image != null && !"".equals(image)){
			String[] images = image.split(",");
			return images;
		}
		return null;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
}
