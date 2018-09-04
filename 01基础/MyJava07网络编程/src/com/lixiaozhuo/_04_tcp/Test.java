package com.lixiaozhuo._04_tcp;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

//TCP传输案例
public class Test {
	public static void main(String[] args) {
		new ClientTest().start();
		new ServerTest().start();

	}
}

//客户端
class ClientTest extends Thread {
	public void run() {
		try (Socket client = new Socket("127.0.0.1", 8888);) {
			// 获取客户端的输入流对象
			Scanner sc = new Scanner(client.getInputStream());
			String str = "";
			while (sc.hasNextLine()) {
				str = sc.nextLine();
				System.out.println("服务端的数据:" + str);
				if ("end".equals(str)) {
					break;
				}
			}
			sc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

//服务端
class ServerTest extends Thread {
	public void run() {
		try (ServerSocket server = new ServerSocket(8888);) {
			System.out.println("准备就绪");
			// 接受连接该服务端的客户端对象
			Socket client = server.accept();
			System.out.println("连接客户端:" + client.getInetAddress());
			Scanner sc = new Scanner(System.in);
			PrintStream out = new PrintStream(client.getOutputStream());
			String str = "";
			while (sc.hasNextLine()) {
				str = sc.nextLine();
				out.println(str);
				if ("end".equals(str)) {
					break;
				}
			}
			out.close();
			sc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}