package com.cshr.test;

import java.lang.reflect.Constructor;

import org.junit.Test;

import com.cshr.entity.B;

/**
 * 
 *<p>Title:Test3 </p>
 *Description: 
 *3、写一个B类，类如下：
public class B{
	public B(){
		System.out.println("调用默认构造方法");
	}

	public B(int a){
		System.out.println("调用B(int a)构造方法");
	}

	public B(Integer a){
		System.out.println("调用B(Integer a)构造方法");
	}
}
再写一个测试类，使用反射技术分别调用B类的三个构造方法来造成B类的三个对象。
 *@author LH
 *@date 2018-1-19下午03:40:07
 *@version V1.0
 */
public class Test3 {

	@Test
	public void testMain() throws Exception{
		
		Class c1 = Class.forName("com.cshr.entity.B");
		//通过反射来获取构造方法
		Constructor ct1 = c1.getConstructor();
		B bb = (B) ct1.newInstance();
		
		//获取其带参数的构造方法(public修饰的构造方法)
		Constructor ct2 = c1.getConstructor(int.class);
		B bb2 = (B) ct2.newInstance(11);
		
		Constructor ct3 = c1.getConstructor(Integer.class);
		B bb3 = (B) ct3.newInstance(12);
	}
}
