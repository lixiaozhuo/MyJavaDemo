package com.lixiaozhuo._02_url_connection;

import java.io.InputStream;
import java.io.PrintStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

//url
public class URLConnectionDemo {
	public static void main(String[] args) throws Exception {
		//URL url = new URL("https","blog.csdn.net",80,"/simplebam/article/details/72644094");
		URL url = new URL("http://202.206.3.104/index.php?NCCE=5ef2f0bee431b17577a7bc94943d837f");
		URLConnection con = url.openConnection();
		System.out.println(con);
		InputStream in = con.getInputStream();
		PrintStream p = new PrintStream("1.html","UTF-8");		
		Scanner sc = new Scanner(in,"UTF-8");
		while(sc.hasNextLine()){
			String line = sc.nextLine();
			System.out.println(line);
			p.println(line);
		}
		sc.close();
		p.close();
	}
}
