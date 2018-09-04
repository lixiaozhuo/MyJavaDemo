package com.lixiaozhuo._01_document;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.junit.Test;
import org.w3c.dom.Document;

public class GetDocument {

	@Test
	public void testDocument() throws Exception{
		//获取工厂类对象DocumentBuilderFactory
		DocumentBuilderFactory fac = DocumentBuilderFactory.newInstance();
		//通过工厂类对象创建DocumentBuilder对象
		DocumentBuilder builder = fac.newDocumentBuilder();
		//通过DocumentBuilder对象解析一个xml文件
		Document doc = builder.parse(new File("contacts.xml"));
		System.out.println(doc);
	}


}