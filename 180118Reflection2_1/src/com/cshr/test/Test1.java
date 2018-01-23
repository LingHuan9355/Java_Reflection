package com.cshr.test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.junit.Test;

import com.cshr.entity.A;

/**
 * 
 *<p>Title:Test1 </p>
 *Description: 
 *1、写一个A类，类如下：
public class A{
	public int a;
	private int b;

	public void showA(){
		System.out.println(a);
	}

	private void showB(){
		System.out.println(b);
	}
}
再写一个测试类，要求在此类的main方法中输出A类中的所有属性（包括修饰符及类型），及方法（包括修饰符及返回类型和参数列表）。
 *@author LH
 *@date 2018-1-18下午04:18:32
 *@version V1.0
 */
public class Test1{

	 @Test
	 public void testMain() throws Exception{
		 Class c1 = Class.forName("com.cshr.entity.A");
		 A a = (A) c1.newInstance();
		 
		 //获取所有属性
		 Field [] fs = c1.getDeclaredFields();
		 for (Field ff : fs) {
			 //获取修饰符
			System.out.print(Modifier.toString(ff.getModifiers()));
			//获取所有类型
			System.out.print(" "+ff.getType().getName());
			//获取属性名称
			System.out.print(" " +ff.getName());
			System.out.println();
		}
		 
		 //获取所有方法
		 Method [] ms = c1.getDeclaredMethods();
		 for (Method mm : ms) {
			 //获取方法访问修饰符
			 System.out.print(Modifier.toString(mm.getModifiers()));
			 //获取方法返回类型
			 System.out.print(" "+mm.getReturnType().getName());
			 //获取方法名称
			 System.out.print(" "+mm.getName());
			 //获取参数列表
			 System.out.print(" "+convert(mm.getParameterTypes()));
			 System.out.println();
		}
	 }
	 
	//转换方法
		public static String convert(Class [] parameterTypes){
			StringBuffer sb = new StringBuffer();
			sb.append("(");
			for(int i=0;i<parameterTypes.length;i++){
				sb.append(parameterTypes[i].getSimpleName());
				if(i<parameterTypes.length-1){
					sb.append(",");
				}
			}
			sb.append(")");
			
			return sb.toString();
		}
}
