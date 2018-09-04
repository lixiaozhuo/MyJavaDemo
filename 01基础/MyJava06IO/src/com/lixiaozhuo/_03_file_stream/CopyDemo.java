package com.lixiaozhuo._03_file_stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.InputStream;
import java.io.OutputStream;

//拷贝指定目录的指定类型文件到指定目录
public class CopyDemo {
	public static void main(String[] args) throws Exception {
		File srcDir = new File("file");
		File destDir = new File("java");
		File[] fs = srcDir.listFiles(new FilenameFilter() {
			public boolean accept(File dir, String name) {
				return new File(dir,name).isFile() && name.endsWith(".java");
			}
		});
		
		for(File srcFile : fs){
			InputStream in = new FileInputStream(srcFile);
			String newName = srcFile.getName().substring(0, srcFile.getName().lastIndexOf("."));
			OutputStream out = new FileOutputStream(new File(destDir,newName + ".txt"));			
			byte[] buffer = new byte[2];
			int len = -1;
			while((len = in.read(buffer)) != -1){
				out.write(buffer, 0, len);
			}
			in.close();
			out.close();
		}

	}
}
