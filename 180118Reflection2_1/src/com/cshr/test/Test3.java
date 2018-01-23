package com.cshr.test;

import java.lang.reflect.Constructor;

import org.junit.Test;

import com.cshr.entity.B;

/**
 * 
 *<p>Title:Test3 </p>
 *Description: 
 *3��дһ��B�࣬�����£�
public class B{
	public B(){
		System.out.println("����Ĭ�Ϲ��췽��");
	}

	public B(int a){
		System.out.println("����B(int a)���췽��");
	}

	public B(Integer a){
		System.out.println("����B(Integer a)���췽��");
	}
}
��дһ�������࣬ʹ�÷��似���ֱ����B����������췽�������B�����������
 *@author LH
 *@date 2018-1-19����03:40:07
 *@version V1.0
 */
public class Test3 {

	@Test
	public void testMain() throws Exception{
		
		Class c1 = Class.forName("com.cshr.entity.B");
		//ͨ����������ȡ���췽��
		Constructor ct1 = c1.getConstructor();
		B bb = (B) ct1.newInstance();
		
		//��ȡ��������Ĺ��췽��(public���εĹ��췽��)
		Constructor ct2 = c1.getConstructor(int.class);
		B bb2 = (B) ct2.newInstance(11);
		
		Constructor ct3 = c1.getConstructor(Integer.class);
		B bb3 = (B) ct3.newInstance(12);
	}
}
