package com.lixiaozhuo._15_randomaccessfile;

import java.io.File;
import java.io.RandomAccessFile;

//随机访问文件
public class RandomAccessFileDemo {
	public static void main(String[] args) throws Exception {
		File f = new File("file/raf.txt");
		write(f);
		read(f);

	}

	public static void write(File f) throws Exception {
		RandomAccessFile raf = new RandomAccessFile(f,"rw");
		raf.writeChar('a');
		raf.writeUTF("aaaabb");
		raf.close();
	}

	public static void read(File f) throws Exception {
		RandomAccessFile raf = new RandomAccessFile(f,"r");
		System.out.println("文件指针位置:" + raf.getFilePointer());
		raf.readChar();
		System.out.println("文件指针位置:" + raf.getFilePointer());
		raf.readUTF();
		System.out.println("文件指针位置:" + raf.getFilePointer());
		raf.seek(0);//设置文件指针为0字节处
		raf.skipBytes(12);//设置文件指针跳过12字节
		raf.close();
	}

}
