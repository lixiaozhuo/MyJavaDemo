package com.lixiaozhuo._16_jdk_proxy;

import java.io.FileOutputStream;
import java.io.IOException;

import sun.misc.ProxyGenerator;

//代理工具类,将代理类型保存到本地
public class ProxyUtils {
	public static void main(String[] args) {
		/*
		 * IShow s = (IShow)
		 * Proxy.newProxyInstance(ProxyUtils.class.getClassLoader(),
		 * ProxyUtils.class.getInterfaces(), new InvocationHandler() {
		 * 
		 * @Override public Object invoke(Object proxy, Method method, Object[]
		 * args) throws Throwable { return null; } });
		 * saveProxyClass("D:/a.class",s.getClass().getName(),s.getClass().
		 * getInterfaces());
		 */
	}

	public static boolean saveProxyClass(String path, String proxyClassName,
			Class<?>[] interfaces) {
		if (proxyClassName == null || path == null) {
			return false;
		}

		// get byte of proxy class
		byte[] classFile = ProxyGenerator.generateProxyClass(proxyClassName,
				interfaces);
		FileOutputStream out = null;
		try {
			out = new FileOutputStream(path);
			out.write(classFile);
			out.flush();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
}
