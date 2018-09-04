package com.lixiaozhuo._03_generic_type;

//点类测试
public class PointDemo {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Point<String> p1 = new Point<String>();
		String x1 = p1.getX();
		Point<Integer> p2 = new Point<Integer>();
		Integer x2 = p2.getX();
		Point<Character> p3 = new Point<Character>();
		Character x3 = p3.getX();
		Point<Object> p4 = new Point<Object>();		
		Integer obj = doWork(123);
	}
	//静态方法,只能用泛型方法,通过参数控制T类型
	public static <T> T doWork(T val){
		return null;
	}
}
