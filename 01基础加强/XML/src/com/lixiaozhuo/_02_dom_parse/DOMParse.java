package com.lixiaozhuo._02_dom_parse;

import java.io.File;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

//DOM解析
public class DOMParse {
	private File file = new File("contacts.xml");

	// 得到某个具体的文本节点的内容,取出第二个联系人的姓名
	@Test
	public void test1() throws Exception {
		// 获取文档对象
		Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder()
				.parse(file);
		// 获取根元素
		Element root = doc.getDocumentElement();
		// 获取第二个联系人元素
		NodeList linkmans = root.getElementsByTagName("linkman");
		Element linkman2 = (Element) linkmans.item(1);
		// 获取联系人的姓名元素
		NodeList names = linkman2.getElementsByTagName("name");
		Element name = (Element) names.item(0);
		// 获取姓名元素中的文本
		System.out.println(name.getTextContent());
	}

	// 修改某个元素节点的主体内容,把第一个联系人的邮箱改掉
	@Test
	public void test2() throws Exception {
		// 获取文档对象
		Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder()
				.parse(file);
		// 获取根元素
		Element root = doc.getDocumentElement();
		// 获取第一个联系人对象
		NodeList linkmans = root.getElementsByTagName("linkman");
		Element linkman = (Element) linkmans.item(0);
		// 获取联系人的邮箱元素
		NodeList emails = linkman.getElementsByTagName("email");
		Element email = (Element) emails.item(0);
		// 修改邮箱元素的文本内容
		email.setTextContent("1258290366@qq.com");
		// 数据同步
		Source xmlSource = new DOMSource(doc);
		Result outputTarget = new StreamResult(file);
		TransformerFactory.newInstance().newTransformer().transform(xmlSource,
				outputTarget);

	}

	// 向指定元素节点中增加子元素节点,增加一个联系人信息
	@Test
	public void test3() throws Exception {
		// 获取文档对象
		Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder()
				.parse(file);
		// 获取根元素
		Element root = doc.getDocumentElement();
		// 创建5个新的元素 linkman name email address group
		Element linkman = doc.createElement("linkman");
		Element name = doc.createElement("name");
		Element email = doc.createElement("email");
		Element address = doc.createElement("address");
		Element group = doc.createElement("group");
		;
		// 为name email address group元素设置文本
		name.setTextContent("lxz");
		email.setTextContent("125829366@qq.com");
		address.setTextContent("xxxx");
		group.setTextContent("lxz");
		// 将name email address group加入linkman
		linkman.appendChild(name);
		linkman.appendChild(email);
		linkman.appendChild(address);
		linkman.appendChild(group);
		// 将linkman添加到根元素下
		root.appendChild(linkman);
		// 数据同步
		Source xmlSource = new DOMSource(doc);
		Result outputTarget = new StreamResult(file);
		TransformerFactory.newInstance().newTransformer().transform(xmlSource,
				outputTarget);
	}

	// 操作XML文件属性,设置/获取联系人的id属性
	@Test
	public void test4() throws Exception {
		// 获取文档对象
		Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder()
				.parse(file);
		// 获取根元素
		Element root = doc.getDocumentElement();
		// 获取第三个联系人元素
		NodeList linkmans = root.getElementsByTagName("linkman");
		Element linkman = (Element) linkmans.item(2);
		// 为当前联系人设置属性
		linkman.setAttribute("id", "3");
		// 设置同步
		TransformerFactory.newInstance().newTransformer()
				.transform(new DOMSource(doc), new StreamResult(file));
	}

	// 删除指定元素节点,删除第三个联系人的信息
	@Test
	public void test5() throws Exception {
		// 获取文档对象
		Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder()
				.parse(file);
		// 获取根元素
		Element root = doc.getDocumentElement();
		// 获取第三个联系人元素
		NodeList linkmans = root.getElementsByTagName("linkman");
		Element linkman = (Element) linkmans.item(2);
		// 删除节点
		linkman.getParentNode().removeChild(linkman);
		// 设置同步
		TransformerFactory.newInstance().newTransformer()
				.transform(new DOMSource(doc), new StreamResult(file));
	}

	// 在内存中创建一个Document对象
	@Test
	public void test6() throws Exception {
		// 新建文档对象
		Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder()
				.newDocument();
		// 设置XML版本
		doc.setXmlVersion("1.0");
		// 创建根元素
		Element root = doc.createElement("contact");
		doc.appendChild(root);
		// 创建5个新的元素 linkman name email address group
		Element linkman = doc.createElement("linkman");
		Element name = doc.createElement("name");
		Element email = doc.createElement("email");
		Element address = doc.createElement("address");
		Element group = doc.createElement("group");
		// 为name email address group元素设置文本
		name.setTextContent("lxz");
		email.setTextContent("125829366@qq.com");
		address.setTextContent("xxxx");
		group.setTextContent("lxz");
		// 将name email address group加入linkman
		linkman.appendChild(name);
		linkman.appendChild(email);
		linkman.appendChild(address);
		linkman.appendChild(group);
		// linkman加入根元素
		root.appendChild(linkman);

		TransformerFactory.newInstance().newTransformer().transform(
				new DOMSource(doc), new StreamResult(new File("aaa.xml")));
	}
}
