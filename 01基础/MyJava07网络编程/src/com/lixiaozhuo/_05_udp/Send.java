package com.lixiaozhuo._05_udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

//发送端
public class Send {
	public static void main(String[] args) throws Exception {
		String data = "eeeee";
		//创建发送端数据
		DatagramSocket sender = new DatagramSocket(10010);
		//发送数据                                                                             发送的数据                  发送数据长度(字节数)       发送ip                    
		DatagramPacket dp = new DatagramPacket(data.getBytes(), data.getBytes().length, InetAddress.getLocalHost(),
				10086);//端口
		sender.send(dp);

		sender.close();

	}
}
