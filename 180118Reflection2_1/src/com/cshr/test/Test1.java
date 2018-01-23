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
 *1��дһ��A�࣬�����£�
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
��дһ�������࣬Ҫ���ڴ����main���������A���е��������ԣ��������η������ͣ������������������η����������ͺͲ����б���
 *@author LH
 *@date 2018-1-18����04:18:32
 *@version V1.0
 */
public class Test1{

	 @Test
	 public void testMain() throws Exception{
		 Class c1 = Class.forName("com.cshr.entity.A");
		 A a = (A) c1.newInstance();
		 
		 //��ȡ��������
		 Field [] fs = c1.getDeclaredFields();
		 for (Field ff : fs) {
			 //��ȡ���η�
			System.out.print(Modifier.toString(ff.getModifiers()));
			//��ȡ��������
			System.out.print(" "+ff.getType().getName());
			//��ȡ��������
			System.out.print(" " +ff.getName());
			System.out.println();
		}
		 
		 //��ȡ���з���
		 Method [] ms = c1.getDeclaredMethods();
		 for (Method mm : ms) {
			 //��ȡ�����������η�
			 System.out.print(Modifier.toString(mm.getModifiers()));
			 //��ȡ������������
			 System.out.print(" "+mm.getReturnType().getName());
			 //��ȡ��������
			 System.out.print(" "+mm.getName());
			 //��ȡ�����б�
			 System.out.print(" "+convert(mm.getParameterTypes()));
			 System.out.println();
		}
	 }
	 
	//ת������
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
