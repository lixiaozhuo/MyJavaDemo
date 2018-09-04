package com.lixiaozhuo._01_catch;

//多个异常捕捉
public class MultiCatchDemo {
	public static void main(String[] args) {
		System.out.println("begin");
		String strNum1 = "10";//除数
		String strNum2 = "2b";//被除数
		try {
			int num1 = Integer.parseInt(strNum1);
			int num2 = Integer.parseInt(strNum2);//String转换为int类型
			int ret = num1 / num2;//两数相除
			System.out.println(ret);//结果			
		} catch (ArithmeticException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} catch (NumberFormatException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} catch (Exception e) {//必须在最后
			e.printStackTrace();
		}

		System.out.println("end");
	}
}
