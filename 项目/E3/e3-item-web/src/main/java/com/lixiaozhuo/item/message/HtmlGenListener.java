package com.lixiaozhuo.item.message;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfig;

import com.lixiaozhuo.item.pojo.Item;
import com.lixiaozhuo.pojo.TbItem;
import com.lixiaozhuo.pojo.TbItemDesc;
import com.lixiaozhuo.service.ItemService;

import freemarker.template.Configuration;
import freemarker.template.Template;

/**
 * 监听商品添加消息,生成对应的静态页面
 * 
 * @author lxz
 *
 */
public class HtmlGenListener implements MessageListener {
	/**
	 * 商品条目Mapper
	 */
	@Autowired
	private ItemService itemService;

	/**
	 * freemarker
	 */
	@Autowired
	private FreeMarkerConfig freeMarkerConfig;
	/**
	 * 静态文件输出目录
	 */
	@Value("${HTML_GEN_PATH}")
	private String HTML_GEN_PATH;

	@Override
	public void onMessage(Message message) {
		try {
			// 从消息中取商品id
			TextMessage textMessage = (TextMessage) message;
			String text = textMessage.getText();
			Long itemId = Long.valueOf(text);
			// 等待事务提交
			Thread.sleep(1000);
			// 根据商品id查询商品信息,商品基本信息和商品描述
			TbItem tbItem = itemService.getItemById(itemId);
			Item item = new Item(tbItem);
			// 取商品描述信息
			TbItemDesc itemDesc = itemService.getItemDescById(itemId);
			// 创建一个数据集,把商品数据封装
			Map<String, Object> data = new HashMap<>();
			data.put("item", item);
			data.put("itemDesc", itemDesc);
			// 加载一个模板文件,创建一个模板对象
			Configuration configuration = freeMarkerConfig.getConfiguration();
			Template template = configuration.getTemplate("item.ftl");
			// 创建一个输出流,指定输出的目录及文件名
			Writer out = new FileWriter(
					new File(HTML_GEN_PATH + itemId + ".html"));
			// 静态页面
			template.process(data, out);
			// 关闭流
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
