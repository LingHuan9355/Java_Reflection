package com.cshr.test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import org.junit.Test;

import com.cshr.entity.Student;

/**
 * 
 *<p>Title:MyTest2 </p>
 *Description: 
 *二、获取属性
 *@author LH
 *@date 2018-1-18下午03:14:43
 *@version V1.0
 */
public class MyTest2 {

	@Test
	public void testMian() throws Exception{
         Class c1 = Class.forName("com.cshr.entity.Student");
         Student stu = (Student) c1.newInstance();
         //通过属性的名称获取公共属性对象
         Field f1 = c1.getField("id");
         //设置值
         f1.set(stu, 19);//stu.setId(12);
         //获取值
         System.out.println(f1.get(stu));//stu.getId();
         
       //获取静态属性
         Field f2 = c1.getField("sex");
         f2.set(null, "男");
         System.out.println(f2.get(null));
         
       //获取指定名称的属性(公有---私有)
         Field f3 = c1.getDeclaredField("name");
         f3.setAccessible(true);//解锁
         f3.set(stu, "Tom");
         System.out.println(f3.get(stu));
         
       //获取所有的公共的属性
         Field  [] fs3 = c1.getFields();
         for (Field ff : fs3) {
			//System.out.println(ff);
        	//获取属性访问修饰符
			//System.out.println(Modifier.toString(ff.getModifiers()));
        	//获取属性名称
			//System.out.println(ff.getName());
			//获取属性的类型
			System.out.println(ff.getType().getName());
		}
         
       //获取所有的属性
         Field [] fs4 = c1.getDeclaredFields();
         for (Field ff : fs4) {
			System.out.println(ff);
		}
	}
}
