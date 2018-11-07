package com.lixiaozhuo.search.service;

import com.lixiaozhuo.pojo.SearchResult;

/**
 * 查询服务接口
 * @author lxz
 *
 */
public interface SearchService {
	
	/**
	 * 查询服务
	 * @param keyword 关键字
	 * @param page 查询页
	 * @param rows 页面大小
	 * @return
	 */
	SearchResult search(String keyword,int page,int rows) throws Exception;
}
