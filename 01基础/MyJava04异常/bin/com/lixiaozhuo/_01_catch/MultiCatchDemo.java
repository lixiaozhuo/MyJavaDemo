// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   MultiCatchDemo.java

package com.lixiaozhuo._01_catch;

import java.io.PrintStream;

public class MultiCatchDemo
{

	public MultiCatchDemo()
	{
	}

	public static void main(String args[])
	{
		System.out.println("begin");
		String strNum1 = "10";
		String strNum2 = "2b";
		try
		{
			int num1 = Integer.parseInt(strNum1);
			int num2 = Integer.parseInt(strNum2);
			int ret = num1 / num2;
			System.out.println(ret);
		}
		catch (ArithmeticException e)
		{
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		catch (NumberFormatException e)
		{
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		System.out.println("end");
	}
}
