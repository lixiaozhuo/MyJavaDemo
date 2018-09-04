package com.lixiaozhuo._01_file;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//列出文件的层次结构C:\->file->a->b
public class FileDemo3 {
	public static void main(String[] args) {
		File file = new File("C:/file/a/b/c.avi");
		List<String> parentName = new ArrayList<>();
		listParent(parentName, file);
		Collections.reverse(parentName);
		StringBuilder strB = new StringBuilder(40);
		for (String str : parentName) {
			strB.append(str).append(">");
		}
		strB.deleteCharAt(strB.length() - 1);
		System.out.println(strB);
	}

	private static void listParent(List<String> parentName, File file) {
		if (file.getParentFile() == null) {
			return;
		}
		if (!"".equals(file.getParentFile().getName())) {
			parentName.add(file.getParentFile().getName());
		}else if(!"".equals(file.getParent())){
			parentName.add(file.getParent());
		}
		listParent(parentName, file.getParentFile());
	}
}
