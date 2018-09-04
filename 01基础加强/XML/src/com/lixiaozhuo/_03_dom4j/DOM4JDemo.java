package com.lixiaozhuo._03_dom4j;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.junit.Test;

public class DOM4JDemo {
	// 将所有的联系人信息查询出来
	@Test
	public void test1() throws Exception {
		// 获取文档对象
		SAXReader reader = new SAXReader();
		Document doc = reader.read("contacts.xml");
		// 获取根元素
		Element root = doc.getRootElement();
		// 获取所有联系人
		List<Element> linkmans = root.elements("linkman");
		for (Element linkman : linkmans) {// 遍历联系人

			// Element name = linkman.element("name");
			// Element email = linkman.element("email");
			// Element address = linkman.element("address");
			// Element group = linkman.element("group");
			// String nameText = name.getText();
			// String emailText = email.getText();
			// String addressText = address.getText();
			// String groupText = group.getText();
			System.out.println("name = " + linkman.elementText("name")
					+ " email = " + linkman.elementText("email") + " address = "
					+ linkman.elementText("address") + " group = "
					+ linkman.elementText("group"));

		}
	}

	// 添加一个新的联系人信息
	@Test
	public void test2() throws Exception {
		// 获取文档对象
		SAXReader reader = new SAXReader();
		Document doc = reader.read("contacts.xml");
		// 获取根元素
		Element root = doc.getRootElement();
		// 写入个人信息元素
		Element linkman = root.addElement("linkman");
		linkman.addElement("name").addText("lxz");
		linkman.addElement("email").addText("1258290366");
		linkman.addElement("address").addText("aaaaa");
		linkman.addElement("group").addText("ddd");

		// 传统模式写入
		FileWriter out = new FileWriter("contacts.xml");
		doc.write(out);
		out.close();

		// 漂亮模式写入
		OutputFormat format = OutputFormat.createPrettyPrint();
		XMLWriter writer = new XMLWriter(new FileOutputStream("contacts.xml"),
				format);
		writer.write(doc);
		writer.close();

		// //普通模式写入
		// format = OutputFormat.createCompactFormat();
		// writer = new
		// XMLWriter(new FileOutputStream("contacts.xml"),format);
		// writer.write(doc); writer.close();

	}
}
