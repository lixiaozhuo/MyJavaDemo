package com.lixiaozhuo._01_ip;

import java.net.InetAddress;

//InetAddress存储ip地址
public class InetAddressDemo {
	public static void main(String[] args) throws Exception {
		//InetAddress ip = InetAddress.getByName("www.baidu.com");
		InetAddress ip = InetAddress.getByAddress(new byte[]{(byte)202,(byte)206,3,104});
		System.out.println(ip);
		System.out.println(ip.getHostName());//主机名称
		System.out.println(ip.getHostAddress());//ip地址
		System.out.println(InetAddress.getLocalHost());//本地ip
		
		System.out.println(ip.isReachable(100));
	}
}
