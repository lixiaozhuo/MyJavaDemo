package com.lixiaozhuo._04_set;

import java.util.HashSet;
import java.util.Set;

class Student {
	private int sn;
	private String name;
	private int age;

	public Student(int sn, String name, int age) {
		super();
		this.sn = sn;
		this.name = name;
		this.age = age;
	}

	public String toString() {
		return "Student [sn=" + sn + ", name=" + name + ", age=" + age + "]";
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + sn;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (sn != other.sn)
			return false;
		return true;
	}

	

}

//HashSet
public class HashSetDemo3 {
	public static void main(String[] args) {
         Set<Student>  set = new HashSet<>();   
         set.add(new Student(1,"a",1));
         set.add(new Student(1,"b",2));
         set.add(new Student(1,"",3));
         set.add(new Student(1,"",4));
         System.out.println(set);
	}
}
