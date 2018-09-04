package com.lixiaozhuo._01_file;

import java.io.File;

//批量修改文件名称
public class FileDemo4 {
	public static void main(String[] args) {
		File file = new File("C:/file/a");
		File[] files = file.listFiles();
		String oldChar = "1";
		for(File f : files){
			String newName = f.getName().replace(oldChar, "");
			f.renameTo(new File(file , newName));//完整路径
		}
	}
}
