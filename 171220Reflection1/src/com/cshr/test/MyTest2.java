package com.cshr.test;

import org.junit.Test;

import com.cshr.entity.Student;

/**
 * 
 *<p>Title:MyTest2 </p>
 *Description: 
 *
 *@author LH
 *@date 2017-12-20下午05:53:36
 *@version V1.0
 */
public class MyTest2 {

	/**
	 * 2.Class类型获取的四种方式
	 * @throws Exception
	 */
	@Test
	public void testMian() throws Exception{
		//一、通过类名找到类，返回Class类型(及时加载)
		//即时加载（会马上打印静态块的代码）
		//Class c1 = Class.forName("com.cshr.entity.Student");
		
		//二、通过class文件加载(延时加载就是等着用它的时候才会加载)
		//延时加载(不会打印静态块的代码)
		//加载类，但是没有马上加载,只有当new出这个类的对象时才会加载
	    //Class c2 = Student.class;
	    //Student stu = (Student) c2.newInstance();
		
		//三、通过对象的引用获取其Class类型
		//Student stu3 = new Student();
		//Class c3 = stu3.getClass();
		
		//4、类加载器的方式(延时加载)
		ClassLoader loader = ClassLoader.getSystemClassLoader();
		Class c4 = loader.loadClass("com.cshr.entity.Student");
		c4.newInstance();
		
	}
}
