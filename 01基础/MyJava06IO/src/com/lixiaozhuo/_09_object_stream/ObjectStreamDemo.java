package com.lixiaozhuo._09_object_stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

//使用对象流实现序列化和反序列化
public class ObjectStreamDemo {
	public static void main(String[] args) throws Exception {
		File file = new File("file/object.txt");
		writeObject(file);
		readObject(file);
	}
	public static void writeObject(File file) throws Exception{
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
		out.writeObject(new User());
		out.writeObject(new User());
		out.close();
	}
	public static void readObject(File file) throws Exception{
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
		Object o = in.readObject();
		System.out.println(o);
		o = in.readObject();
		System.out.println(o);
		in.close();
	}
	
}
