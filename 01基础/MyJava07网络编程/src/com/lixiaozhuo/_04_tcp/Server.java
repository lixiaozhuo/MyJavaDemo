package com.lixiaozhuo._04_tcp;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

//服务端
public class Server {
	public static void main(String[] args) throws Exception {

		String data = "欢迎访问";

		//创建服务端,指定端口为8888
		ServerSocket server = new ServerSocket(8888);
		System.out.println("准备就绪");
		//接受连接该服务端的客户端对象
		boolean flag = true;
		while (flag) {
			Socket client = server.accept();
			System.out.println("连接客户端:" + client.getInetAddress());
			//该客户端的输出流对象,给该对象客户端输出数据
			PrintStream out = new PrintStream(client.getOutputStream());
			out.println(data);
			out.close();
		}
		server.close();
	}
}
