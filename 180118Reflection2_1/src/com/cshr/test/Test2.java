package com.cshr.test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.junit.Test;

import com.cshr.entity.A;

/**
 * 
 *<p>Title:Test2 </p>
 *Description: 
 *2����дһ�������࣬Ҫ���ڴ����main����������һ��A��Ķ���
 *ʹ�÷��似�����˶����е�a=6��b=10;��ʹ�÷��似������showA��showB������
 *@author LH
 *@date 2018-1-18����04:45:30
 *@version V1.0
 */
public class Test2 {

	@Test
	public void testMian() throws Exception{
		Class c1=Class.forName("com.cshr.entity.A");
		 A aa=(A) c1.newInstance();
		 
		 Field f1 = c1.getField("a");
		 f1.set(aa, 6);
		// System.out.println(f1.get(aa));
		 
		 Field f2 = c1.getDeclaredField("b");
		 f2.setAccessible(true);
		 f2.set(aa, 10);
		// System.out.println(f2.get(aa));
		 
		 Method m1 =c1.getMethod("showA");
		 System.out.println(m1.invoke(aa));
		 
		 Method m2 = c1.getDeclaredMethod("showB");
		 m2.setAccessible(true);
		 System.out.println(m2.invoke(aa));
	}
}
