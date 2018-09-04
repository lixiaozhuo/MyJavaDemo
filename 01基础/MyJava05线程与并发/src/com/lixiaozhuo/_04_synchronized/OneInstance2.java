package com.lixiaozhuo._04_synchronized;

//单例模式-懒汉式
public class OneInstance2 {
	private OneInstance2(){}
	private static OneInstance2 instance = null;
	//存在线程不安全问题
	public static OneInstance2 getInstance1(){
		if(instance == null){
			instance = new OneInstance2();
		}
		return instance;
	}
	//同步方法，此时的同步监听对象是ArrayUtil.class
	//synchronized作用域太大，损耗性能
	synchronized public static OneInstance2 getInstance2(){
		if(instance == null){
			instance = new OneInstance2();
		}
		return instance;
	}
	
	//双重检查加锁
	public static OneInstance2 getInstance3(){
		if(instance == null){
			synchronized(OneInstance2.class){
				if(instance == null){
					instance = new OneInstance2();
				}
			}			
		}
		return instance;
	}
}
