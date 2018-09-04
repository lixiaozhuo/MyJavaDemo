package com.lixiaozhuo._09_object_stream;

//需要序列化的对象
public class User implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	private String name;
	transient private String password;//瞬态字段,不可序列化
	private int age;

	public User() {
		this("王","123",18);
	}

	public User(String name, String password, int age) {
		super();
		this.name = name;
		this.password = password;
		this.age = age;
	}

	public String toString() {
		return "User [name=" + name + ", password=" + password + ", age=" + age + "]";
	}

	
}
