package com.cshr.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import com.cshr.entity.InfoTest;
import com.sun.org.apache.xpath.internal.Arg;

/**
 * 
 *<p>Title:ReflectionUtils </p>
 *Description: 
 *1.自己写一个ReflectionUtils(反射工具)类,在这个类中封装如下几个方法
a.根据传入Class类型、属性名称获取静态属性值的方法
b.根据传入Class类型、属性名称获取实例属性值的方法
c.根据传入Class类型、方法名称、参数列表(Class类型的数组)、参数值(Object类型的数组) 调用静态方法的方法
d.根据传入Class类型、方法名称、参数列表(Class类型的数组)、参数值(Object类型的数组) 调用实例方法的方法
 *@author LH
 *@date 2018-1-19下午04:06:40
 *@version V1.0
 */
public class ReflectionUtils {

	//a.根据传入Class类型、属性名称获取静态属性值的方法
	public void getField(String className,String fieldName) throws Exception{
		 Class c1 = Class.forName("com.cshr.entity."+className);
         
		//获取静态属性
	    Field f2 = c1.getField("sex");
	    f2.set(null, "男");
	    System.out.println(f2.get(null));
	}
	
	//b.根据传入Class类型、属性名称获取实例属性值的方法
	public void getField2(String className,String fieldName) throws Exception{
		 Class c1 = Class.forName("com.cshr.entity."+className);
		 InfoTest stu = (InfoTest) c1.newInstance();

	     Field f3 = c1.getDeclaredField("name");
         f3.setAccessible(true);//解锁
         f3.set(stu, "Tom");
         System.out.println(f3.get(stu));
	}
	
	//c.根据传入Class类型、方法名称、参数列表(Class类型的数组)、参数值(Object类型的数组) 调用静态方法的方法
	public void getMethod(String className,String methodName,Class [] args,Object [] obj) throws Exception{
		 Class c1 = Class.forName("com.cshr.entity."+className);
		 
		 Method m3 = c1.getMethod(methodName,args);
		 
	     m3.invoke(null,obj);
	}
	//d.根据传入Class类型、方法名称、参数列表(Class类型的数组)、参数值(Object类型的数组) 调用实例方法的方法
	public void getMethod2(String className,String methodName,Class [] args,Object [] obj) throws Exception{
		Class c1 = Class.forName("com.cshr.entity."+className);
		InfoTest stu = (InfoTest) c1.newInstance();
		
		 Method m4 = c1.getDeclaredMethod(methodName,args);
		 m4.setAccessible(true);//解锁
	     m4.invoke(stu,obj);
	}
}
