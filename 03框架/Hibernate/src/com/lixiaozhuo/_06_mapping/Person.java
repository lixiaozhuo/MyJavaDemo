package com.lixiaozhuo._06_mapping;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter@Setter
@ToString
public class Person {
	private Long id;
	private String name;
	private Set<String> emailSet = new HashSet<>();
	List<String> emailList = new ArrayList<>();
	List<String> emailBag = new ArrayList<>();
}
