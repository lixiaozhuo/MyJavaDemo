package com.lixiaozhuo.solrj;

import org.apache.solr.client.solrj.impl.CloudSolrServer;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;

/**
 * 索引集群版测试
 * @author lxz
 *
 */
public class TestSolrCloud {
	@Test
	public void testAddDocument() throws Exception {
		// 创建一个集群的连接,应该使用CloudSolrServer创建
		// zKHost:zookeeper的地址列表
		CloudSolrServer solrServer = new CloudSolrServer(
				"192.168.25.128:2281,192.168.25.128:2282,192.168.25.128:2283");
		// 设置一个defaultCollection属性
		solrServer.setDefaultCollection("collection2");
		// 创建一个文档对象
		SolrInputDocument document = new SolrInputDocument();
		// 向文档中添加域
		document.setField("id", "solrcloud1");
		document.setField("item_title", "测试商品1");
		document.setField("item_price", 123);
		// 把文件添加进索引库
		solrServer.add(document);
		// 提交
		solrServer.commit();
	}
}
