package com.cshr.test;

import org.junit.Test;

/**
 * 
 *<p>Title:MyTest4 </p>
 *Description: 
 *
 *@author LH
 *@date 2017-12-21上午11:27:33
 *@version V1.0
 */
public class MyTest4 {

	/**
	 * 类加载器的原理(原则)
	 * 向上委托原则-->确保java中核心api不被篡改
	 * 一致性原则
	 * 向上透明性原则
	 * @throws Exception 
	 */
	   @SuppressWarnings("unchecked")
	@Test
	   public void testMain4() throws Exception{
		   Class c = Class.forName("com.cshr.entity.Student");
	       System.out.println(c.getClassLoader());
	   }
}
