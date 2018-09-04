package com.lixiaozhuo._03_generic_type;

//T表示是一种类型,该类型具体是什么,由类的调用者决定
public class Point<T> {
	private T x;
	private T y;
	public T getX() {
		return x;
	}
	public void setX(T x) {
		this.x = x;
	}
	public T getY() {
		return y;
	}
	public void setY(T y) {
		this.y = y;
	}
}
// T:type  E:element   K:key   V:value  