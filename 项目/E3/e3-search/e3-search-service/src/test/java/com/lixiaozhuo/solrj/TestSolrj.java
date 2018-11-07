package com.lixiaozhuo.solrj;
/**
 * solrj功能测试
 * @author lxz
 *
 */

import java.util.List;
import java.util.Map;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;

public class TestSolrj {
	@Test
	public void addDocument() throws Exception {
		// 创建一个SolrServer对象,创建一个连接,参数solr服务的url
		SolrServer solrServer = new HttpSolrServer(
				"http://192.168.25.128/solr/collection1");
		// 创建一个文档对象SolrInputDocument
		SolrInputDocument document = new SolrInputDocument();
		// 向文档对象中添加域,文档中必须包含一个id域,所有的域的名称必须在schema.xml中定义
		document.addField("id", "doc01");
		document.addField("item_title", 1000);
		// 把文档写入索引库
		solrServer.add(document);
		// 提交
		solrServer.commit();
	}

	@Test
	public void deleteDocument() throws Exception {
		// 创建一个SolrServer对象,创建一个连接,参数solr服务的url
		SolrServer solrServer = new HttpSolrServer(
				"http://192.168.25.128/solr/collection1");
		//删除文档
		//solrServer.deleteById("doc01");
		solrServer.deleteByQuery("id:doc01");
		//提交
		solrServer.commit();
	}
	
	/**
	 *简单查询
	 * @throws Exception
	 */
	@Test
	public void queryIndex() throws Exception {
		//创建一个SolrServer对象
		SolrServer solrServer = new HttpSolrServer(
				"http://192.168.25.128/solr/collection1");
		//创建一个SolrQuery对象
		SolrQuery query = new SolrQuery();
		//设置查询条件
		//query.setQuery("*:*");
		query.set("q","*:*");
		//执行查询,得到QueryResponse对象
		QueryResponse queryResponse = solrServer.query(query);
		//取文档列表,取查询结果总记录数
		SolrDocumentList solrDocumentList = queryResponse.getResults();
		System.out.println("查询结果总记录数" + solrDocumentList.getNumFound());;
		//遍历文档列表,从文档中取域的内容
		for (SolrDocument solrDocument : solrDocumentList) {
			System.out.println(solrDocument.get("id"));
			System.out.println(solrDocument.get("item_title"));
			System.out.println(solrDocument.get("item_sell_point"));
			System.out.println(solrDocument.get("item_price"));
			System.out.println(solrDocument.get("item_image"));
			System.out.println(solrDocument.get("item_category_name"));
		}
		
	}
	
	/**
	 * 高级查询
	 * @throws Exception
	 */
	@Test
	public void queryIndex2() throws Exception {
		//创建一个SolrServer对象
		SolrServer solrServer = new HttpSolrServer(
				"http://192.168.25.128/solr/collection1");
		//创建一个SolrQuery对象
		SolrQuery query = new SolrQuery();
		//设置查询条件
		query.set("q","三星");
		//设置分页条件
		query.setStart(1);
		query.setRows(20);
		//设置搜索域
		query.set("df", "item_title");
		//开启高亮
		query.setHighlight(true);
		query.addHighlightField("item_title");
		query.setHighlightSimplePre("<em>");
		query.setHighlightSimplePost("</em>");
		
		//执行查询,得到QueryResponse对象
		QueryResponse queryResponse = solrServer.query(query);
		//取文档列表,取查询结果总记录数
		SolrDocumentList solrDocumentList = queryResponse.getResults();
		System.out.println("查询结果总记录数" + solrDocumentList.getNumFound());;
		//读取高亮查询结果
		Map<String, Map<String, List<String>>> highlighting = queryResponse.getHighlighting();
		//遍历文档列表,从文档中取域的内容
		for (SolrDocument solrDocument : solrDocumentList) {
			System.out.println(solrDocument.get("id"));
			//高亮结果
			List<String> list = highlighting.get(solrDocument.get("id")).get("item_title");
			String title ="";
			if(list != null && list.size()>0){
				title = list.get(0);
			}else{
				title=solrDocument.get("item_title").toString();
			}
			System.out.println(title);
			//其他结果
			System.out.println(solrDocument.get("item_sell_point"));
			System.out.println(solrDocument.get("item_price"));
			System.out.println(solrDocument.get("item_image"));
			System.out.println(solrDocument.get("item_category_name"));
		}
		
	}
}
