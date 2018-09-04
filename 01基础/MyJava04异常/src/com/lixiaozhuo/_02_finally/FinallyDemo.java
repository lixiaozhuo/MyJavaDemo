package com.lixiaozhuo._02_finally;

//finally语句
public class FinallyDemo {
	public static void main(String[] args) {
		test1();
		System.out.println(test2());
		System.out.println(test3());
	}

	// finally
	private static void test1() {
		System.out.println("start");
		try {
			int ret = 10 / 1;
			System.out.println(ret);
		} catch (ArithmeticException e) {
			// e.printStackTrace();
			System.out.println(e.getMessage());
			System.exit(0);// 退出jvm
		} finally {
			System.out.println("关闭资源");// 此时不执行
		}

		System.out.println("end");
	}

	// finally有return语句,永远返回finally中的结果,避免该情况
	@SuppressWarnings("finally")
	private static int test2() {
		try {
			return 1;
		} finally {
			return 100;
		}
	}

	private static int test3() {
		int a = 1;
		try {
			return a;
		} finally {
			++a;

		}
	}
}
