package com.lixiaozhuo.search.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lixiaozhuo.pojo.SearchItem;
import com.lixiaozhuo.pojo.SearchResult;

/**
 * 商品搜索DAO
 * @author lxz
 *
 */
@Repository
public class SearchDAO {
	/**
	 * solrServer
	 */
	@Autowired
	private SolrServer solrServer;
	
	/**
	 * 根据查询条件查询索引库
	 * @param query 查询条件
	 * @return
	 */
	public SearchResult search(SolrQuery query) throws Exception{
		//根据query 查询索引库
		QueryResponse queryResponse = solrServer.query(query);
		//取查询结果
		SolrDocumentList solrDocumentList = queryResponse.getResults();
		//取查询结果总记录数
		long numFound = solrDocumentList.getNumFound();
		//设置返回结果总记录数
		SearchResult result = new SearchResult();
		result.setRecourdCount(numFound);
		List<SearchItem> itemList = new ArrayList<>();
		
		//高亮显示结果
		Map<String, Map<String, List<String>>> highlighting = queryResponse.getHighlighting();
		
		//取商品列表,需要取高亮显示
		for (SolrDocument solrDocument : solrDocumentList) {
			SearchItem item = new SearchItem();
			item.setId(solrDocument.get("id").toString());
			item.setCategory_name(solrDocument.get("item_category_name").toString());
			item.setImage(solrDocument.get("item_image").toString());
			item.setPrice((long) solrDocument.get("item_price"));
			item.setSell_point(solrDocument.get("item_sell_point").toString());
			//取高亮显示
			List<String> list = highlighting.get(solrDocument.get("id")).get("item_title");
			String title ="";
			if(list != null && list.size()>0){
				title = list.get(0);
			}else{
				title=solrDocument.get("item_title").toString();
			}
			item.setTitle(title);
			//添加到商品列表
			itemList.add(item);
		}
		result.setItemList(itemList);
		//返回结果
		return result;
	}
}
