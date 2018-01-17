package com.cshr.test;

import org.junit.Test;

/**
 * 
 *<p>Title:MyTestClassLoader </p>
 *Description: 
 *类加载器 
 * 1、应用程序加载器(系统加载器);
 * 2、扩展加载器;
 * 3、根加载器(引导加载器);
 *@author LH
 *@date 2017-12-21上午10:24:43
 *@version V1.0
 */
public class MyTestClassLoader {

	/**
	 * 类加载器的原理(原则)
	 * 向上委托原则-->确保java中核心api不被篡改
	 * 一致性原则
	 * 向上透明性原则
	 */
	   @Test
	  public void testMian() throws Exception{
		   
		 //应用程序加载器(加载的是当前的classpath下所有的自定义java类)
		 Class c1 = Class.forName("com.cshr.entity.Student");
		 //sun.misc.Launcher$AppClassLoader@3125fe1
		 System.out.println(c1.getClassLoader());
		 
		 //D:\Program Files\Java\jdk1.6.0_02\jre\lib\ext
		 //扩展加载器加载的是JDK目录下的一个ext目录的class文件
		 //sun.misc.Launcher$ExtClassLoader@addbf1
		// Class c2 = Class.forName("sun.security.pkcs11.KeyCache");
		 //System.out.println(c2.getClassLoader());
		 
		
	    //根加载器加载的是java中核心api
		 Class c3 = Class.forName("java.lang.String");
		//null
		 System.out.println(c3.getClassLoader());
		 System.out.println("==============");
		 
		 ClassLoader loader = c1.getClassLoader();
		 System.out.println(loader);
		 System.out.println(loader.getParent());
		 System.out.println(loader.getParent().getParent());
	  }
}
