package com.lixiaozhuo._05_udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

//接收端
public class Receive {
	public static void main(String[] args) throws Exception {
		//创建接收端对象
		DatagramSocket receiver = new DatagramSocket(10086);
		byte [] buffer = new byte[1024];
		//接受数据
		DatagramPacket dp = new DatagramPacket(buffer ,1024);		
		receiver.receive(dp);
		//获取接受到的数据
		String data = new String(dp.getData(),0,dp.getLength());
		System.out.println(data);
		
		receiver.close();
	}
}
