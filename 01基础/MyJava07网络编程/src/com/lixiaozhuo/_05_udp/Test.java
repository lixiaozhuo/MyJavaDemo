package com.lixiaozhuo._05_udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

//UPD传输案例
public class Test {
	public static void main(String[] args) {
		new Thread(new ReceiveTest()).start();
		new Thread(new SendTest()).start();
	}
}

// 发送端
class SendTest implements Runnable {
	public void run() {
		try (DatagramSocket sender = new DatagramSocket(10010);) {
			String str = "";
			Scanner sc = new Scanner(System.in);
			while (sc.hasNextLine()) {
				str = sc.nextLine();
				DatagramPacket dp = new DatagramPacket(str.getBytes(), str.getBytes().length,
						InetAddress.getByName("127.0.0.1"), 10086);
				sender.send(dp);
				if ("end".equals(str)) {
					break;
				}
			}
			sc.close();
		} catch (Exception e) {
			e.getMessage();
		}

	}
}

// 接收端
class ReceiveTest implements Runnable {
	public void run() {
		try (DatagramSocket receiver = new DatagramSocket(10086);) {
			while (true) {
				byte[] buffer = new byte[1024];
				DatagramPacket dp = new DatagramPacket(buffer, 1024);
				receiver.receive(dp);
				String str = new String(buffer, 0, dp.getLength());
				System.out.println("服务端数据:" + str);
				if ("end".equals(str)) {
					System.out.println("结束传输");
					break;
				}
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}
}