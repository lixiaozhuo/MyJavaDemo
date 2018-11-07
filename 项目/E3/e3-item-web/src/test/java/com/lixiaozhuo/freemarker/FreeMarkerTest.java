package com.lixiaozhuo.freemarker;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import freemarker.template.Configuration;
import freemarker.template.Template;

/**
 * freemarker测试
 * 
 * @author lxz
 *
 */
public class FreeMarkerTest {
	@Test
	public void testFreeMarker() throws Exception {
		//创建一个模板文件
		//创建一个Configuration对象
		Configuration configuration = new Configuration(Configuration.getVersion());
		//设置模板文件保存的目录
		configuration.setDirectoryForTemplateLoading(new File(
				"C:/Users/lxz/workspace/e3-item-web/src/main/webapp/WEB-INF/test"));
		//模板文件的编码格式 utf-8
		configuration.setDefaultEncoding("utf-8");
		//加载一个模板文件,创建一个模板对象
		Template template = configuration.getTemplate("test.ftl");
		//创建一个数据集,可以是pojo也可以是map
		Map<String,Object> data = new HashMap<>();
		data.put("hello","freemarker");
		data.put("date", new Date());
		data.put("val", null);
		//创建一个Writer对象,指定输出文件的路径及文件名
		Writer out = new FileWriter(new File("C:/file/freemark/1.txt"));
		//生成静态页面
		template.process(data, out);
		//关闭流
		out.close();
	}
}
