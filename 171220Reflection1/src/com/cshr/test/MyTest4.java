package com.cshr.test;

import org.junit.Test;

/**
 * 
 *<p>Title:MyTest4 </p>
 *Description: 
 *
 *@author LH
 *@date 2017-12-21����11:27:33
 *@version V1.0
 */
public class MyTest4 {

	/**
	 * ���������ԭ��(ԭ��)
	 * ����ί��ԭ��-->ȷ��java�к���api�����۸�
	 * һ����ԭ��
	 * ����͸����ԭ��
	 * @throws Exception 
	 */
	   @SuppressWarnings("unchecked")
	@Test
	   public void testMain4() throws Exception{
		   Class c = Class.forName("com.cshr.entity.Student");
	       System.out.println(c.getClassLoader());
	   }
}
