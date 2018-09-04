package com.lixiaozhuo._01_file;

import java.io.File;

//需求:列出指定目录中所有的文件,包括子文件夹中的所有文件(使用递归算法(recursion)).
public class FileDemo2 {
	public static void main(String[] args) {
		File file = new File("C:/file/a");
		listFile(file);
	}
	private static void listFile(File file){
		System.out.println(file);
		if(!file.isDirectory()){
			return ;
		}		
		File[] files = file.listFiles();
		for(File f : files){
			if(f.isDirectory()){
				listFile(f);
			}else{
				System.out.println(f);
			}
		}
	}
}
