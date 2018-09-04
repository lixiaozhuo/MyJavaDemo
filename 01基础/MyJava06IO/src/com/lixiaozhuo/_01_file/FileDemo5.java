package com.lixiaozhuo._01_file;

import java.io.File;
import java.io.FilenameFilter;

//文件过滤器
public class FileDemo5 {
	public static void main(String[] args) {
		File dir = new File("C:/file/a");
		File[] files = dir.listFiles(new FilenameFilter() {
			public boolean accept(File dir, String name) {
				return new File(dir, name).isFile() && name.endsWith(".exe");
			}
		});
		for (File file : files) {
			System.out.println(file.getName());
		}
	}
}
