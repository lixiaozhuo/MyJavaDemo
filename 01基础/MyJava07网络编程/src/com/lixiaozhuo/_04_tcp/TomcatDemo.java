package com.lixiaozhuo._04_tcp;

import java.io.File;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

//简单模拟Tomcats服务器
public class TomcatDemo {
	public static void main(String[] args) throws Exception {
		ServerSocket server = new ServerSocket(9999);
		boolean flag = true;		
		while(flag)
		{
			Socket client = server.accept();
			PrintStream ps = new PrintStream(client.getOutputStream());
			Scanner sc = new Scanner(new File("hello.html"));
			while(sc.hasNextLine()){
				ps.print(sc.nextLine());
			}
			sc.close();
		}
		server.close();		
		
	}
}
