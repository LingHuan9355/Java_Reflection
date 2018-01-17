package com.cshr.test;

import java.util.ArrayList;

import org.junit.Test;

/**
 * 
 *<p>Title:MyTest </p>
 *Description: 
 *
 *@author LH
 *@date 2017-12-20下午05:40:08
 *@version V1.0
 */
public class MyTest {

	/**
	 * Class类(自省类)
	 * @throws Exception 
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void TestMian() throws Exception{
		   
		   //自定义的类
		   Class c1 = Class.forName("com.cshr.entity.Student");
		   System.out.println(c1.getName());
		   System.out.println(c1.getSuperclass());
		   
		   Class c2 = Class.forName("java.lang.String");
		   System.out.println(c2.getName());
		   System.out.println(c2.getSuperclass());
		   
		   Class c3 = Class.forName("java.lang.NullPointerException");
		   while(c3 !=null){
		      System.out.println(c3.getName());
		      c3 = c3.getSuperclass();
		   }
		   
		   Class c4 = ArrayList.class;
			while(c4!=null){
					System.out.println(c4.getName());
					c4 = c4.getSuperclass();
			}
			System.out.println("----------------");
			//(3).基础类和包装类 
			//得到基础类和包装类
 			Class c5 =  Integer.class; 
 			System.out.println(c5.getName());
 			
 			Class c6 = int.class; 
			System.out.println(c6.getName());
			
			//在jdk1.5版本之后
			Class c7 = Integer.TYPE; 
		    System.out.println(c7.getName());
	}
}
