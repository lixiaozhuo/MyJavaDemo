package com.lixiaozhuo._04_set;

import java.util.HashSet;
import java.util.Set;
class A{
	public boolean equals(Object obj){
		return true;
	}
	public String toString(){
		return "A";
	}
}

class B{
	public int hashCode(){
		return 1;
	}
	public String toString(){
		return "B";
	}
}

class C{
	public boolean equals(Object obj){
		return true;
	}
	public int hashCode(){
		return 1;
	}
	public String toString(){
		return "C";
	}
}

class D{
	public boolean equals(Object obj){
		return true;
	}
	public int hashCode(){
		return 1;
	}
	public String toString(){
		return "D";
	} 
}
//当往HashSet集合中添加新的对象的时候,先会判断该对象和集合对象中的hashCode值:
//    1):不等: 直接把该新的对象存储到hashCode指定的位置.
//    2):相等: 再继续判断新对象和集合对象中的equals做比较.
//                   1>:hashCode相同,equals为true: 则视为是同一个对象,则不保存在哈希表中.
//                   1>:hashCode相同,equals为false:非常麻烦,存储在之前对象同槽为的链表上(拒绝,操作比较麻烦).

//HashSet判断是否为同一个元素
public class HashSetDemo2 {
	public static void main(String[] args) {
		Set<Object> set = new HashSet<>();
		set.add(new C());
		set.add(new C());
		set.add(new D());
		set.add(new D());
		set.add(new A());
		set.add(new A());
		set.add(new B());
		set.add(new B());
		
		System.out.println(set);
	}
}