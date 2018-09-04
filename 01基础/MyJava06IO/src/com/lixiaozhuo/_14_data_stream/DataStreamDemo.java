package com.lixiaozhuo._14_data_stream;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

//数据流
public class DataStreamDemo {
	public static void main(String[] args) throws Exception {
		File f = new File("file/out");
		write(f);
		read(f);
	}

	private static void write(File f) throws Exception {
		DataOutputStream dos = new DataOutputStream(new FileOutputStream(f));
		dos.writeInt(7);
		dos.writeUTF("abddde");
		dos.close();
	}

	private static void read(File f) throws Exception {
		DataInputStream dis = new DataInputStream(new FileInputStream(f));
		System.out.println(dis.readInt());
		System.out.println(dis.readUTF());
		dis.close();
	}
}
