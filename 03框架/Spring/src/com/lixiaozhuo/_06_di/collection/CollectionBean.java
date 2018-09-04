package com.lixiaozhuo._06_di.collection;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import lombok.Setter;
import lombok.ToString;

@Setter@ToString
public class CollectionBean {
	private Set<String> set;
	private List<String> list;
	private String[] array;
	private Map<String,String> map;
	private Properties prop;
}
