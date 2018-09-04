package com.lixiaozhuo._02_junit;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

//赋予MyJUnit功能
public class App {
	public static void main(String[] args) throws Exception{
		List<Method> beforeMethod = new ArrayList<>();
		List<Method> testMethod = new ArrayList<>();
		List<Method> afterMethod = new ArrayList<>();		
		//获取目标字节码对象
		Class<?> clazz = MyJUnitDemo.class;		
		//获取注解
		Method[] methods = clazz.getMethods();
		//分类处理->把带有不同注解的对象分开
		//带有before   带有after   带有test
		for(Method method : methods){
			if(method.isAnnotationPresent(MyBefore.class)){
				beforeMethod.add(method);
			}
			if(method.isAnnotationPresent(MyTest.class)){
				testMethod.add(method);
			}
			if(method.isAnnotationPresent(MyAfter.class)){
				afterMethod.add(method);				
			}			
		}
		System.out.println(beforeMethod);
		System.out.println(testMethod);
		System.out.println(afterMethod);
		
		//控制执行顺序
		for(Method method : testMethod){
			//先执行MyBefore
			for(Method method1 : beforeMethod){
				method1.invoke(clazz.newInstance());
			}
			method.invoke(clazz.newInstance());//执行MyTest
			//后执行MyAfter
			for(Method method1 : afterMethod){
				method1.invoke(clazz.newInstance());				
			}			
		}
		
		
	}
}
