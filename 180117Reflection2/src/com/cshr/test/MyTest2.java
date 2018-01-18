package com.cshr.test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import org.junit.Test;

import com.cshr.entity.Student;

/**
 * 
 *<p>Title:MyTest2 </p>
 *Description: 
 *������ȡ����
 *@author LH
 *@date 2018-1-18����03:14:43
 *@version V1.0
 */
public class MyTest2 {

	@Test
	public void testMian() throws Exception{
         Class c1 = Class.forName("com.cshr.entity.Student");
         Student stu = (Student) c1.newInstance();
         //ͨ�����Ե����ƻ�ȡ�������Զ���
         Field f1 = c1.getField("id");
         //����ֵ
         f1.set(stu, 19);//stu.setId(12);
         //��ȡֵ
         System.out.println(f1.get(stu));//stu.getId();
         
       //��ȡ��̬����
         Field f2 = c1.getField("sex");
         f2.set(null, "��");
         System.out.println(f2.get(null));
         
       //��ȡָ�����Ƶ�����(����---˽��)
         Field f3 = c1.getDeclaredField("name");
         f3.setAccessible(true);//����
         f3.set(stu, "Tom");
         System.out.println(f3.get(stu));
         
       //��ȡ���еĹ���������
         Field  [] fs3 = c1.getFields();
         for (Field ff : fs3) {
			//System.out.println(ff);
        	//��ȡ���Է������η�
			//System.out.println(Modifier.toString(ff.getModifiers()));
        	//��ȡ��������
			//System.out.println(ff.getName());
			//��ȡ���Ե�����
			System.out.println(ff.getType().getName());
		}
         
       //��ȡ���е�����
         Field [] fs4 = c1.getDeclaredFields();
         for (Field ff : fs4) {
			System.out.println(ff);
		}
	}
}
