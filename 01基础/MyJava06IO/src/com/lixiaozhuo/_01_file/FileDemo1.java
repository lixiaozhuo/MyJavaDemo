package com.lixiaozhuo._01_file;

import java.io.File;
import java.io.IOException;

public class FileDemo1 {
	public static void main(String[] args) throws IOException {
		/*系统平台的分隔符*/
		/*//获取属性分隔符
		System.out.println(File.pathSeparator);
		System.out.println(File.pathSeparatorChar);
		//获取路径分割符
		System.out.println(File.separator);
		System.out.println(File.separatorChar);*/
		test1();
		test2();
		test3();
		test4();

	}

	/*	操作File路径和名称:
		File getAbsoluteFile() :获取绝对路径
		String getAbsolutePath():获取绝对路径
		String getPath() :获取文件路径
		String getName() :获取文件名称
		File getParentFile():获取上级目录文件
		String getParent() :获取上级目录路径*/
	private static void test1() {
		//创建File对象
		File f1 = new File("c:/file");
		System.out.println(f1.getAbsolutePath());//c:\file
		System.out.println(f1.getAbsoluteFile());//c:\file
		System.out.println(f1.getPath());//‪C:\file\1.txt
		System.out.println(f1.getName());//1.txt
		System.out.println(f1.getParentFile());//‪C:\file
		System.out.println(f1.getParent());//‪C:\file
	}

	/*	检测File状态的方法:
		boolean canExecute() :判断是否是可执行文件
		boolean canRead() :判断该文件是否可读
		boolean canWrite():判断该文件是否可写
		boolean isHidden():判断该文件是否是隐藏文件
		long lastModified():判断该文件的最后修改时间
		long length():获取该文件的长度大小(单位字节)*/
	private static void test2() {
		//创建File对象
		//File f1 = new File("c:/");
		File f1 = new File("C:/file/1.txt");
		//File f1 = new File("C:/file","1.txt");
		System.out.println(f1.getAbsoluteFile());//c:\file		
		System.out.println(f1.exists());
		System.out.println(f1.canExecute());
		System.out.println(f1.canRead());
		System.out.println(f1.canWrite());
		System.out.println(f1.isHidden());
		System.out.println(f1.lastModified());
		System.out.println(f1.length());
	}

	/*File类中方法-文件操作:
	boolean isFile() :是否是文件
	boolean createNewFile() :创建新的文件
	static File createTempFile(String prefix, String suffix) :创建临时文件
	boolean delete() :删除文件
	void deleteOnExit() :在JVM停止时删除文件
	boolean exists():判断文件是否存在
	boolean renameTo(File dest) :重新修改名称*/
	private static void test3() throws IOException {
		File f1 = new File("C:/file/1.txt");
		System.out.println(f1.isFile());
		if (!f1.exists()) {
			f1.createNewFile();
		} else {
			f1.renameTo(new File("C:/file/2.txt"));
		}
		//产生一个临时文件(临时使用的文件,随时都可以被清除掉)
		File.createTempFile("abc", ".tmp", null);
	}

	/*File类中方法-目录操作
	boolean isDirectory() :判断是否是目录
	boolean mkdir()  :创建当前目录
	boolean mkdirs() :创建当前目录和上级目录
	String[] list() :列出所有的文件名
	File[] listFiles() :列出所有文件对象
	static File[] listRoots() :列出系统盘符*/
	private static void test4() {
		File f1 = new File("C:/file");
		System.out.println(f1.isDirectory());
		File f2 = new File("C:/file/a");
		System.out.println(f2.mkdir());
		String[] names = f2.list();
		for (String name : names) {
			System.out.println(name);
		}
		File[] files = f2.listFiles();
		for (File file : files) {
			System.out.println(file);
		}
		File[] roots = File.listRoots();
		for (File root : roots) {
			System.out.println(root);
		}
	}
}
