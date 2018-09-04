package com.lixiaozhuo._03_extends_vs_implements;

//每一个同学好比是一个线程对象
class Person extends Thread{
	private int num = 50;//苹果总数
	public Person(String name){
		super(name);
	}
	public void run(){
		for(int i = 0 ;i < 50;i++){
			if(num > 0){
				System.out.println(getName()+"吃了编号为" + num-- + "的苹果");
			}
		}
	}
}



//使用继承Thread方式来实现,三个同学吃50个苹果
public class ExtendsDemo {
	public static void main(String[] args) {
		//创建三个线程,吃苹果
		new Person("A").start();
		new Person("B").start();
		new Person("C").start();
	}
}
