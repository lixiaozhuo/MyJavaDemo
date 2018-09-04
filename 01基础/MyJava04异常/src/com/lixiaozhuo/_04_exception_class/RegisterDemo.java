package com.lixiaozhuo._04_exception_class;

//注册过程中错误处理
public class RegisterDemo {
	private static String[] names = { "will", "luc", "lily" };

	public static void main(String[] args) {
		try {
			checkUserName("will");
			System.out.println("添加成功");
		} catch (LogicException e) {
			System.out.println(e.getMessage());
		}
	}

	//检查用户姓名重复
	public static boolean checkUserName(String userName) {
		for (String name : names) {
			if (name.equals(userName)) {
				throw new LogicException(userName + "已存在");
			}
		}
		return false;
	}
}
