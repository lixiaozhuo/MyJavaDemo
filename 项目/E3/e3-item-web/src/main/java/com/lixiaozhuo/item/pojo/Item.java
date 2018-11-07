package com.lixiaozhuo.item.pojo;

import com.lixiaozhuo.pojo.TbItem;
/**
 * 商品详情包装,添加获取图片数组属性
 * @author lxz
 *
 */
public class Item extends TbItem {

	private static final long serialVersionUID = 1L;
	
	public Item(TbItem tbItem){
		this.setBarcode(tbItem.getBarcode());
		this.setCid(tbItem.getCid());
		this.setCreated(tbItem.getCreated());
		this.setId(tbItem.getId());
		this.setImage(tbItem.getImage());
		this.setNum(tbItem.getNum());
		this.setPrice(tbItem.getPrice());
		this.setSellPoint(tbItem.getSellPoint());
		this.setStatus(tbItem.getStatus());
		this.setTitle(tbItem.getTitle());
		this.setUpdated(tbItem.getUpdated());

	}
	
	/**
	 * 获取图片数组
	 * @return
	 */
	public String[] getImages(){
		if(this.getImage() != null && !"".equals(this.getImage())){
			String[] images = this.getImage().split(",");
			return images;
		}
		return null;
	}

}
