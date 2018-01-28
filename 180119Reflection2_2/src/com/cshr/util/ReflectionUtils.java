package com.cshr.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import com.cshr.entity.InfoTest;
import com.sun.org.apache.xpath.internal.Arg;

/**
 * 
 *<p>Title:ReflectionUtils </p>
 *Description: 
 *1.�Լ�дһ��ReflectionUtils(���乤��)��,��������з�װ���¼�������
a.���ݴ���Class���͡��������ƻ�ȡ��̬����ֵ�ķ���
b.���ݴ���Class���͡��������ƻ�ȡʵ������ֵ�ķ���
c.���ݴ���Class���͡��������ơ������б�(Class���͵�����)������ֵ(Object���͵�����) ���þ�̬�����ķ���
d.���ݴ���Class���͡��������ơ������б�(Class���͵�����)������ֵ(Object���͵�����) ����ʵ�������ķ���
 *@author LH
 *@date 2018-1-19����04:06:40
 *@version V1.0
 */
public class ReflectionUtils {

	//a.���ݴ���Class���͡��������ƻ�ȡ��̬����ֵ�ķ���
	public void getField(String className,String fieldName) throws Exception{
		 Class c1 = Class.forName("com.cshr.entity."+className);
         
		//��ȡ��̬����
	    Field f2 = c1.getField("sex");
	    f2.set(null, "��");
	    System.out.println(f2.get(null));
	}
	
	//b.���ݴ���Class���͡��������ƻ�ȡʵ������ֵ�ķ���
	public void getField2(String className,String fieldName) throws Exception{
		 Class c1 = Class.forName("com.cshr.entity."+className);
		 InfoTest stu = (InfoTest) c1.newInstance();

	     Field f3 = c1.getDeclaredField("name");
         f3.setAccessible(true);//����
         f3.set(stu, "Tom");
         System.out.println(f3.get(stu));
	}
	
	//c.���ݴ���Class���͡��������ơ������б�(Class���͵�����)������ֵ(Object���͵�����) ���þ�̬�����ķ���
	public void getMethod(String className,String methodName,Class [] args,Object [] obj) throws Exception{
		 Class c1 = Class.forName("com.cshr.entity."+className);
		 
		 Method m3 = c1.getMethod(methodName,args);
		 
	     m3.invoke(null,obj);
	}
	//d.���ݴ���Class���͡��������ơ������б�(Class���͵�����)������ֵ(Object���͵�����) ����ʵ�������ķ���
	public void getMethod2(String className,String methodName,Class [] args,Object [] obj) throws Exception{
		Class c1 = Class.forName("com.cshr.entity."+className);
		InfoTest stu = (InfoTest) c1.newInstance();
		
		 Method m4 = c1.getDeclaredMethod(methodName,args);
		 m4.setAccessible(true);//����
	     m4.invoke(stu,obj);
	}
}
