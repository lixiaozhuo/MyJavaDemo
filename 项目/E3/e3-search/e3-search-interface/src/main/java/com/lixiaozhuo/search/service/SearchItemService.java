package com.lixiaozhuo.search.service;

import com.lixiaozhuo.pojo.E3Result;

/**
 * 查询商品服务接口
 * 
 * @author lxz
 *
 */
public interface SearchItemService {
	/**
	 * 将商品所有条目导入索引库中
	 * @return 页面响应
	 */
	E3Result importAllItems();
}
