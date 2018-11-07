package com.lixiaozhuo.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * 搜索结果封装
 * 
 * @author lxz
 *
 */
public class SearchResult implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 内容列表
	 */
	private List<SearchItem> itemList;

	/**
	 * 总页数
	 */
	private int totalPages;

	/**
	 * 结果总数
	 */
	private long recourdCount;

	public List<SearchItem> getItemList() {
		return itemList;
	}

	public void setItemList(List<SearchItem> itemList) {
		this.itemList = itemList;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public long getRecourdCount() {
		return recourdCount;
	}

	public void setRecourdCount(long recourdCount) {
		this.recourdCount = recourdCount;
	}

}
