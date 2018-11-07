package com.lixiaozhuo.search.service.impl;

import java.util.List;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lixiaozhuo.pojo.E3Result;
import com.lixiaozhuo.pojo.SearchItem;
import com.lixiaozhuo.search.mapper.ItemMapper;
import com.lixiaozhuo.search.service.SearchItemService;

/**
 * 商品索引库维护业务逻辑
 * 
 * @author lxz
 *
 */
@Service
public class SearchItemServiceImpl implements SearchItemService {
	/**
	 * 商品Mapper
	 */
	@Autowired
	private ItemMapper itemMapper;
	
	/**
	 * solrServer
	 */
	@Autowired
	private SolrServer solrServer;

	@Override
	public E3Result importAllItems() {
		try {
			//清空索引库
			solrServer.deleteByQuery("*:*");
			
			//查询商品列表
			List<SearchItem> itemList = itemMapper.getItemList();
			//遍历商品列表
			for (SearchItem searchItem : itemList) {
				//创建一个文档对象
				SolrInputDocument document = new SolrInputDocument();
				//向文档对象中添加域
				document.addField("id", searchItem.getId());
				document.addField("item_title", searchItem.getTitle());
				document.addField("item_price", searchItem.getPrice());
				document.addField("item_sell_point", searchItem.getSell_point());
				document.addField("item_image", searchItem.getImage());
				document.addField("item_category_name", searchItem.getCategory_name());
				//把文档对象写入索引库
				solrServer.add(document);
			}
			//提交
			solrServer.commit();
			//返回响应结果
			return E3Result.ok();
		} catch (Exception e) {
			e.printStackTrace();
			return E3Result.build(500,"导入索引库错误");
		}
	}

}
