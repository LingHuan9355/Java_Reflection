package com.cshr.test;

import org.junit.Test;

/**
 * 
 *<p>Title:MyTestClassLoader </p>
 *Description: 
 *������� 
 * 1��Ӧ�ó��������(ϵͳ������);
 * 2����չ������;
 * 3����������(����������);
 *@author LH
 *@date 2017-12-21����10:24:43
 *@version V1.0
 */
public class MyTestClassLoader {

	/**
	 * ���������ԭ��(ԭ��)
	 * ����ί��ԭ��-->ȷ��java�к���api�����۸�
	 * һ����ԭ��
	 * ����͸����ԭ��
	 */
	   @Test
	  public void testMian() throws Exception{
		   
		 //Ӧ�ó��������(���ص��ǵ�ǰ��classpath�����е��Զ���java��)
		 Class c1 = Class.forName("com.cshr.entity.Student");
		 //sun.misc.Launcher$AppClassLoader@3125fe1
		 System.out.println(c1.getClassLoader());
		 
		 //D:\Program Files\Java\jdk1.6.0_02\jre\lib\ext
		 //��չ���������ص���JDKĿ¼�µ�һ��extĿ¼��class�ļ�
		 //sun.misc.Launcher$ExtClassLoader@addbf1
		// Class c2 = Class.forName("sun.security.pkcs11.KeyCache");
		 //System.out.println(c2.getClassLoader());
		 
		
	    //�����������ص���java�к���api
		 Class c3 = Class.forName("java.lang.String");
		//null
		 System.out.println(c3.getClassLoader());
		 System.out.println("==============");
		 
		 ClassLoader loader = c1.getClassLoader();
		 System.out.println(loader);
		 System.out.println(loader.getParent());
		 System.out.println(loader.getParent().getParent());
	  }
}
